package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testChangePlayerToMoveAfterSuccessfulMove(){
        Game game = new Game();
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "a2-a4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
    }


    @Test
    public void testMoveBlackPawnAfterWhiteMove(){
        Game game = new Game();
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "a2-a4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "b7-b5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
    }

    @Test
    public void testInvalidInput(){
        Game game = new Game();
        String str = "asdafhjkahjk";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "asdafhjkahjk";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "a0-b0";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "a2-a0";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "i2-i4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "a2-g2";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "AA-AA";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
    }

    @Test
    public void testCastlingValid(){
        Game game = new Game();
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(1,7)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(2,7)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(3,7)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,7)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(6,7)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(1,0)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(2,0)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(3,0)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,0)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(6,0)));
        game.move("O-O");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("O-O-O");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
    }
}
