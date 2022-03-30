package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Game;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
    @Test
    public void testKingMoveValid(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,3)));
    }

    @Test
    public void testKingMoveInvalid(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,4)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(6,3)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(0,0)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,0)));
        //move to threatened space
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(4,3)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,4)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,4)));
        //eat threatened piece
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,3)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(3,2)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,3)));
    }

    @Test
    public void testKingEatPawns(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,4)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(3,3)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(5,3)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(3,5)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(5,5)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(4,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,5)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,5)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(3,4)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(5,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(3,4)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(5,4)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(4,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard,new Coordinates(4,3)));
    }

    @Test
    public void testCastling(){
        Chessboard chessboard = new Chessboard();
        King king = new King(Player.WHITE, new Coordinates(4,7));
        chessboard.addPiece(king);
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(0,7)));
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(7,7)));
        assertTrue(king.canCastle(chessboard,true));
        assertTrue(king.canCastle(chessboard,false));

        chessboard = new Chessboard();
        king = new King(Player.BLACK, new Coordinates(4,0));
        chessboard.addPiece(king);
        chessboard.addPiece(new Rook(Player.BLACK, new Coordinates(0,0)));
        chessboard.addPiece(new Rook(Player.BLACK, new Coordinates(7,0)));
        assertTrue(king.canCastle(chessboard,true));
        assertTrue(king.canCastle(chessboard,false));
    }

    @Test
    public void testInvalidCastling(){
        Chessboard chessboard = new Chessboard();
        King king = new King(Player.WHITE, new Coordinates(4,7));
        chessboard.addPiece(king);
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(0,7)));
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(7,7)));
        king.setMoved(true);
        assertFalse(king.canCastle(chessboard,true));
        assertFalse(king.canCastle(chessboard,false));
        king.setMoved(false);
        chessboard.getPiece(new Coordinates(0,7)).setMoved(true);
        chessboard.getPiece(new Coordinates(7,7)).setMoved(true);
        assertFalse(king.canCastle(chessboard,true));
        assertFalse(king.canCastle(chessboard,false));
        chessboard.getPiece(new Coordinates(0,7)).setMoved(false);
        chessboard.getPiece(new Coordinates(7,7)).setMoved(false);
        chessboard.addPiece(new Knight(Player.WHITE, new Coordinates(1,7)));
        chessboard.addPiece(new Knight(Player.WHITE, new Coordinates(6,7)));
        assertFalse(king.canCastle(chessboard,true));
        assertFalse(king.canCastle(chessboard,false));

        chessboard = new Chessboard();
        king = new King(Player.BLACK, new Coordinates(4,0));
        chessboard.addPiece(king);
        chessboard.addPiece(new Rook(Player.BLACK, new Coordinates(0,0)));
        chessboard.addPiece(new Rook(Player.BLACK, new Coordinates(7,0)));
        king.setMoved(true);
        assertFalse(king.canCastle(chessboard,true));
        assertFalse(king.canCastle(chessboard,false));
        king.setMoved(false);
        chessboard.getPiece(new Coordinates(0,0)).setMoved(true);
        chessboard.getPiece(new Coordinates(7,0)).setMoved(true);
        assertFalse(king.canCastle(chessboard,true));
        assertFalse(king.canCastle(chessboard,false));
        chessboard.getPiece(new Coordinates(0,0)).setMoved(false);
        chessboard.getPiece(new Coordinates(7,0)).setMoved(false);
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(1,0)));
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(6,0)));
        assertFalse(king.canCastle(chessboard,true));
        assertFalse(king.canCastle(chessboard,false));
    }

    @Test
    public void testThreatenedCastling(){
        Chessboard chessboard = new Chessboard();
        King king = new King(Player.WHITE, new Coordinates(4,7));
        Bishop bishop = new Bishop(Player.BLACK, new Coordinates(4,5));
        Rook[] rook = {new Rook(Player.BLACK, new Coordinates(3,5)),
                new Rook(Player.BLACK, new Coordinates(5,5))};
        chessboard.addPiece(king);
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(0,7)));
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(7,7)));
        chessboard.addPiece(bishop);
        assertFalse(king.canCastle(chessboard,true));
        assertFalse(king.canCastle(chessboard,false));
        chessboard.removePiece(bishop);
        chessboard.addPiece(rook[0]);
        chessboard.addPiece(rook[1]);
        assertFalse(king.canCastle(chessboard,true));
        assertFalse(king.canCastle(chessboard,false));
        rook[0].setLocation(new Coordinates(0,5));
        rook[1].setLocation(new Coordinates(0,5));
        assertFalse(king.canCastle(chessboard,true));
        assertFalse(king.canCastle(chessboard,false));
        chessboard.removePiece(rook[1]);
        rook[1].setLocation(new Coordinates(4,5));
        assertFalse(king.canCastle(chessboard,true));
        assertFalse(king.canCastle(chessboard,false));
    }
}
