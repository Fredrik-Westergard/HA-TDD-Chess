package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Game;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {
    @Test
    public void testMoveBishopValid(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Bishop(Player.WHITE, new Coordinates(4,4)));
        //multiple spaces
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,0)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(1,7)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,1)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,7)));
        //one space
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,3)));
    }

    @Test
    public void testBishopMoveInvalid(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Bishop(Player.WHITE, new Coordinates(4,4)));
        //not diagonal long move
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,1)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(2,7)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,2)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(6,7)));
        //no move
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,4)));
        //not diagonal one space
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,4)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,3)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,4)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,5)));

        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(3,3)));
        //no jump over pieces
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,0)));
    }

    @Test
    public void testBishopCanEatBishop(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Bishop(Player.WHITE, new Coordinates(4,4)));
        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(3,5)));
        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(0,0)));
        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(7,1)));
        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(7,7)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,0)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,1)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(7,7)));
    }

    @Test
    public void testBishopCantEatBishop(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Bishop(Player.WHITE, new Coordinates(4,4)));
        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(3,4)));
        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(4,3)));
        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(4,5)));
        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(5,4)));
        //bishops vertically/horizontally around
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,4)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,3)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,5)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,4)));

        //no jump over piece
        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(0,0)));
        chessboard.addPiece(new Bishop(Player.BLACK, new Coordinates(3,3)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,0)));
    }


}
