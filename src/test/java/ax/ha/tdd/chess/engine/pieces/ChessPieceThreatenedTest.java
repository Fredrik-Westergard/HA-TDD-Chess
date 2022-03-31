package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChessPieceThreatenedTest {
    @Test
    public void testSpacesThreatenedByBishop(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Bishop(Player.WHITE, new Coordinates(4,4)));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(2,2), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(1,1), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(0,0), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,5), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(2,6), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(1,7), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,5), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(6,6), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(7,7), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(6,2), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(7,1), Player.BLACK));
    }

    @Test
    public void testSpacesThreatenedByKing(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,4)));
        //vertical/horizontal
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,5), Player.BLACK));
        //diagonal
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,5), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,5), Player.BLACK));
    }

    @Test
    public void testSpacesThreatenedByKnight(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Knight(Player.WHITE, new Coordinates(4,4)));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(2,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,2), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,2), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(6,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(2,5), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,6), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(6,5), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,6), Player.BLACK));
    }

    @Test
    public void testSpacesThreatenedByPawn(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Pawn(Player.WHITE, new Coordinates(4,4)));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,3), Player.BLACK));
    }

    @Test
    public void testSpacesNotThreatenedByPawn(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Pawn(Player.WHITE, new Coordinates(4,4)));
        assertFalse(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,5), Player.BLACK));
        assertFalse(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,5), Player.BLACK));
    }

    @Test
    public void testSpacesThreatenedByQueen(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Queen(Player.WHITE, new Coordinates(4,4)));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(2,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(1,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(0,4), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,2), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,1), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,0), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(6,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(7,4), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,5), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,6), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,7), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(2,2), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(1,1), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(0,0), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,5), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(2,6), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(1,7), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,5), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(6,6), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(7,7), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(6,2), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(7,1), Player.BLACK));
    }

    @Test
    public void testSpacesThreatenedByRook(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(4,4)));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(3,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(2,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(1,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(0,4), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,3), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,2), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,1), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,0), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(5,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(6,4), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(7,4), Player.BLACK));

        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,5), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,6), Player.BLACK));
        assertTrue(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(4,7), Player.BLACK));
    }
}
