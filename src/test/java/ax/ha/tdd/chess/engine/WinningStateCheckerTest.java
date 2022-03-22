package ax.ha.tdd.chess.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningStateCheckerTest {

    @Test
    public void testIsCheckStateActive(){
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
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(game.getBoard(),Player.BLACK));
        game.move("d4-f3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(WinningState.CHECK, WinningStateChecker.checkState(game.getBoard(),Player.WHITE));
    }

    @Test
    public void testIsCheckStateActiveThenInactive(){
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
}
