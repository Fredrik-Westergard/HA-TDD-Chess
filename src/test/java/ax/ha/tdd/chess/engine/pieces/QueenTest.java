package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTest {
    @Test
    public void testQueenMoveValidMultipleSpacesDiagonally(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Queen(Player.WHITE, new Coordinates(4,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,0)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(1,7)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,1)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,7)));
    }

    @Test
    public void testQueenMoveValidOneSpaceDiagonally(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Queen(Player.WHITE, new Coordinates(4,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,3)));

    }

    @Test
    public void testQueenMoveValidMultipleSpacesStraight(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Queen(Player.WHITE, new Coordinates(4,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,0)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,7)));
    }

    @Test
    public void testQueenMoveValidOneSpaceStraight(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Queen(Player.WHITE, new Coordinates(4,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,4)));

    }

    @Test
    public void testQueenMoveInvalid(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Queen(Player.WHITE, new Coordinates(4,4)));
        chessboard.addPiece(new Queen(Player.WHITE, new Coordinates(4,5)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,5)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,6)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,1)));
    }

    @Test
    public void testQueenEatQueens(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Queen(Player.WHITE, new Coordinates(4,4)));
        chessboard.addPiece(new Queen(Player.BLACK, new Coordinates(4,5)));
        chessboard.addPiece(new Queen(Player.BLACK, new Coordinates(0,0)));
        chessboard.addPiece(new Queen(Player.BLACK, new Coordinates(2,6)));
        chessboard.addPiece(new Queen(Player.BLACK, new Coordinates(1,4)));
        chessboard.addPiece(new Queen(Player.BLACK, new Coordinates(6,4)));
        chessboard.addPiece(new Queen(Player.BLACK, new Coordinates(6,2)));
        chessboard.addPiece(new Queen(Player.BLACK, new Coordinates(7,7)));
        chessboard.addPiece(new Queen(Player.BLACK, new Coordinates(4,1)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,0)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(2,6)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(1,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(6,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(6,2)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,7)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,1)));
    }
}
