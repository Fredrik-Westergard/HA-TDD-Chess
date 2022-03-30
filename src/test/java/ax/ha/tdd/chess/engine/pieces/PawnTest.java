package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Game;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    @Test
    public void testIsMovePawnValid(){
        Chessboard chessboard = Chessboard.startingBoard();
        assertTrue(chessboard.getPiece(new Coordinates(0,1)).canMove(chessboard, new Coordinates(0,2)));
        assertTrue(chessboard.getPiece(new Coordinates(0,1)).canMove(chessboard, new Coordinates(0,3)));
        assertTrue(chessboard.getPiece(new Coordinates(0,6)).canMove(chessboard, new Coordinates(0,5)));
        assertTrue(chessboard.getPiece(new Coordinates(0,6)).canMove(chessboard, new Coordinates(0,4)));
    }

    @Test
    public void testIsMovePawnInvalid(){
        Chessboard chessboard = Chessboard.startingBoard();
        assertFalse(chessboard.getPiece(new Coordinates(0,1)).canMove(chessboard, new Coordinates(1,2)));
        assertFalse(chessboard.getPiece(new Coordinates(0,1)).canMove(chessboard, new Coordinates(0,4)));
        assertFalse(chessboard.getPiece(new Coordinates(0,6)).canMove(chessboard, new Coordinates(0,6)));
        assertFalse(chessboard.getPiece(new Coordinates(0,6)).canMove(chessboard, new Coordinates(0,7)));

        chessboard = new Chessboard();
        chessboard.addPiece(new Pawn(Player.WHITE, new Coordinates(4,4)));
        assertFalse(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(4,5)));
    }

    @Test
    public void testWhitePawnEatBlackPawn(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Pawn(Player.WHITE, new Coordinates(4,4)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(3,3)));
        assertTrue(chessboard.getPiece(new Coordinates(4,4)).canMove(chessboard, new Coordinates(3,3)));
        assertTrue(chessboard.getPiece(new Coordinates(3,3)).canMove(chessboard, new Coordinates(4,4)));
    }
}
