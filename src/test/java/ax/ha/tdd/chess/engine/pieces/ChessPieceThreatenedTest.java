package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Game;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChessPieceThreatenedTest {

    @Test
    public void testKingThreatenedByKnight(){
        Game game = new Game();
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,0)));
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        Assertions.assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "b1-c3";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "b8-a6";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "c3-d5";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a6-b4";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "d5-f6";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        assertTrue(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
    }

    @Test
    public void testKingThreatenedByBishop(){
        Game game = new Game();
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,0)));
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "e2-e4";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "d7-d5";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "f1-b5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        assertTrue(ChessPieceThreatened.isThreatened(game.getBoard(), new Coordinates(4,0), Player.BLACK));
    }

    @Test
    public void testKingThreatenedByRook(){
        Game game = new Game();
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,0)));
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "a2-a4";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "e7-e5";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "a1-a3";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "e5-e4";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "a3-e3";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "b8-a6";
        game.move(str);
        assertFalse(ChessPieceThreatened.isThreatened(game.getBoard(),new Coordinates(4,0), Player.BLACK));
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "e3-e4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        assertTrue(ChessPieceThreatened.isThreatened(game.getBoard(), new Coordinates(4,0), Player.BLACK));
    }
}
