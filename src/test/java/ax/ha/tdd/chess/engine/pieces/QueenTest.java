package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {
    @Test
    public void testQueenMoveValid(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Queen(Player.WHITE, new Coordinates(4,4)));
        //multiple spaces diagonally
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,0)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(1,7)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,1)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,7)));
        //one space diagonally
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,3)));
        //multiple spaces vertically
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,0)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,7)));
        //one space vertically
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
