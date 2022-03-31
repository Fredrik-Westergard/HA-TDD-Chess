package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Game;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    @Test
    public void testKnightMoveValidStartingBoard(){
        Chessboard chessboard = Chessboard.startingBoard();
        assertTrue(chessboard.getPiece(new Coordinates(1,7)).canMove(chessboard, new Coordinates(0,5)));
        assertTrue(chessboard.getPiece(new Coordinates(1,7)).canMove(chessboard, new Coordinates(2,5)));
        assertTrue(chessboard.getPiece(new Coordinates(6,7)).canMove(chessboard, new Coordinates(5,5)));
        assertTrue(chessboard.getPiece(new Coordinates(6,7)).canMove(chessboard, new Coordinates(7,5)));
        assertTrue(chessboard.getPiece(new Coordinates(1,0)).canMove(chessboard, new Coordinates(0,2)));
        assertTrue(chessboard.getPiece(new Coordinates(1,0)).canMove(chessboard, new Coordinates(2,2)));
        assertTrue(chessboard.getPiece(new Coordinates(6,0)).canMove(chessboard, new Coordinates(5,2)));
        assertTrue(chessboard.getPiece(new Coordinates(6,0)).canMove(chessboard, new Coordinates(7,2)));
    }

    @Test
    public void testKnightMoveValidInTheMiddle(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Knight(Player.WHITE, new Coordinates(4,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(3,2)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(5,2)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(2,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(6,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(2,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(6,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(3,6)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(5,6)));
    }

    @Test
    public void testKnightMoveInvalid(){
        Chessboard chessboard = Chessboard.startingBoard();
        assertFalse(chessboard.getPiece(new Coordinates(1,7)).canMove(chessboard, new Coordinates(3,6)));
        assertFalse(chessboard.getPiece(new Coordinates(1,7)).canMove(chessboard, new Coordinates(3,5)));
    }

    @Test
    public void testKnightEatKnight(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Knight(Player.WHITE, new Coordinates(4,4)));
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(3,2)));
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(5,2)));
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(2,3)));
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(6,3)));
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(2,5)));
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(6,5)));
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(3,6)));
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(5,6)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(3,2)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(5,2)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(2,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(6,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(2,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(6,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(3,6)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(5,6)));
    }
}
