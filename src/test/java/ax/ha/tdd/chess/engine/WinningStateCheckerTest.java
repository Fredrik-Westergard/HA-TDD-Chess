package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningStateCheckerTest {

    @Test
    public void testIsCheckStateActive(){
        Game game = new Game();
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,1)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,7)));
        game.move("b1-c3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("b8-c6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("c3-d5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("c6-d4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("d5-f6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(game.getBoard(),Player.BLACK));
        game.move("d4-f3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(game.getBoard(),Player.WHITE));
    }

    @Test
    public void testIsCheckStateActiveThenInactive(){
        Game game = new Game();
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,1)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,7)));
        game.move("b1-c3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("b8-c6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("c3-d5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("c6-d4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("d5-f6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(game.getBoard(),Player.BLACK));
        game.move("d4-f3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(game.getBoard(),Player.WHITE));
        game.move("f6-d5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(WinningState.PLAYING, WinningStateChecker.checkState(game.getBoard(),Player.BLACK));
        game.move("f3-d4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(WinningState.PLAYING, WinningStateChecker.checkState(game.getBoard(),Player.WHITE));
    }

    @Test
    public void testForCheckMate(){
        Game game = new Game();
        game.move("b1-c3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("b8-c6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("c3-d5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("c6-d4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("d5-f6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(WinningState.CHECKMATE, WinningStateChecker.checkState(game.getBoard(),Player.BLACK));

        game = new Game();
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,1)));
        game.move("b1-c3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("b8-c6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("c3-d5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("c6-d4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game.move("d5-f6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(game.getBoard(),Player.BLACK));
        game.move("d4-f3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(WinningState.CHECKMATE, WinningStateChecker.checkState(game.getBoard(),Player.WHITE));
    }

    @Test
    public void testForSkipOverCheckMate(){
        Game game = new Game();
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(5,0)));
        game.getBoard().removePiece(game.getBoard().getPiece(new Coordinates(3,1)));
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "d2-d4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "e7-e5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "d4-e5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a7-a5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "d1-d8";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(game.getBoard(),Player.BLACK));
        str = "a5-a4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(game.getBoard(),Player.BLACK));
        str = "c1-g5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        assertEquals(WinningState.CHECKMATE, WinningStateChecker.checkState(game.getBoard(),Player.BLACK));
    }

}
