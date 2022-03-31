package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTest {
    @Test
    public void testIsMoveRookValidMultipleSpaces(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(4,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,0)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,7)));
    }

    @Test
    public void testIsMoveRookValidOneSpace(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(4,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,4)));
    }

    @Test
    public void testIsMoveRookInvalid(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(4,4)));

        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(1,3)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(0,0)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(4,4)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(5,5)));
    }

    @Test
    public void testRookHasObstacle(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(4,4)));
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(4,3)));

        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(4,2)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(4,3)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(4,0)));
    }

    @Test
    public void testRookEatRook(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(4,4)));
        chessboard.addPiece(new Rook(Player.BLACK, new Coordinates(4,3)));
        chessboard.addPiece(new Rook(Player.BLACK, new Coordinates(4,7)));
        chessboard.addPiece(new Rook(Player.BLACK, new Coordinates(2,4)));
        chessboard.addPiece(new Rook(Player.BLACK, new Coordinates(6,4)));

        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,7)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(2,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(6,4)));
    }
}
