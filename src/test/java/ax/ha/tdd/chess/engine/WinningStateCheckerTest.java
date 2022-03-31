package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningStateCheckerTest {

    @Test
    public void testIsCheckStateActiveWhite(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,7)));
        chessboard.addPiece(new King(Player.BLACK, new Coordinates(4,0)));
        chessboard.setKing(new Coordinates(4,7), Player.WHITE);
        chessboard.setKing(new Coordinates(4,0), Player.BLACK);
        chessboard.addPiece(new Bishop(Player.WHITE, new Coordinates(0,4)));
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(chessboard,Player.BLACK));
    }

    @Test
    public void testIsCheckStateActiveBlack(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,7)));
        chessboard.addPiece(new King(Player.BLACK, new Coordinates(4,0)));
        chessboard.setKing(new Coordinates(4,7), Player.WHITE);
        chessboard.setKing(new Coordinates(4,0), Player.BLACK);
        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(3,5)));
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(chessboard,Player.WHITE));
    }

    @Test
    public void testIsCheckStateActiveThenInactiveWhite(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,7)));
        chessboard.addPiece(new King(Player.BLACK, new Coordinates(4,0)));
        chessboard.setKing(new Coordinates(4,7), Player.WHITE);
        chessboard.setKing(new Coordinates(4,0), Player.BLACK);

        chessboard.addPiece(new Knight(Player.BLACK, new Coordinates(3,5)));
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(chessboard,Player.WHITE));

        chessboard.removePiece(chessboard.getPiece(new Coordinates(3,5)));
        assertEquals(WinningState.PLAYING, WinningStateChecker.checkState(chessboard,Player.WHITE));
    }

    @Test
    public void testIsCheckStateActiveThenInactiveBlack(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,7)));
        chessboard.addPiece(new King(Player.BLACK, new Coordinates(4,0)));
        chessboard.setKing(new Coordinates(4,7), Player.WHITE);
        chessboard.setKing(new Coordinates(4,0), Player.BLACK);

        chessboard.addPiece(new Bishop(Player.WHITE, new Coordinates(0,4)));
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(chessboard,Player.BLACK));

        chessboard.removePiece(chessboard.getPiece(new Coordinates(0,4)));
        assertEquals(WinningState.PLAYING, WinningStateChecker.checkState(chessboard,Player.BLACK));
    }

    @Test
    public void testForCheckMateWhite(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,7)));
        chessboard.addPiece(new King(Player.BLACK, new Coordinates(4,0)));
        chessboard.setKing(new Coordinates(4,7), Player.WHITE);
        chessboard.setKing(new Coordinates(4,0), Player.BLACK);
        chessboard.addPiece(new Rook(Player.BLACK, new Coordinates(0,7)));
        chessboard.addPiece(new Rook(Player.BLACK, new Coordinates(7,6)));
        assertEquals(WinningState.CHECKMATE, WinningStateChecker.checkState(chessboard,Player.WHITE));
    }

    @Test
    public void testForCheckMateBlack(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,7)));
        chessboard.addPiece(new King(Player.BLACK, new Coordinates(4,0)));
        chessboard.setKing(new Coordinates(4,7), Player.WHITE);
        chessboard.setKing(new Coordinates(4,0), Player.BLACK);
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(0,0)));
        chessboard.addPiece(new Rook(Player.WHITE, new Coordinates(7,1)));
        assertEquals(WinningState.CHECKMATE, WinningStateChecker.checkState(chessboard,Player.BLACK));
    }

    @Test
    public void testForSkipOverCheckMate(){
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new King(Player.WHITE, new Coordinates(4,7)));
        chessboard.addPiece(new King(Player.BLACK, new Coordinates(4,0)));
        chessboard.setKing(new Coordinates(4,7), Player.WHITE);
        chessboard.setKing(new Coordinates(4,0), Player.BLACK);
        chessboard.addPiece(new Queen(Player.BLACK, new Coordinates(5,7)));
        chessboard.addPiece(new Pawn(Player.BLACK, new Coordinates(6,6)));
        chessboard.addPiece(new Pawn(Player.WHITE, new Coordinates(3,6)));
        assertEquals(WinningState.CHECKMATE, WinningStateChecker.checkState(chessboard,Player.WHITE));
    }

}
