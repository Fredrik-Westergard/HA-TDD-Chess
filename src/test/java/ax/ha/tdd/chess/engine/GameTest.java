package ax.ha.tdd.chess.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    public void testChangePlayerToMoveAfterSuccessfulMove(){
        Game game = new Game();
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "a2-a4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
    }


    @Test
    public void testMoveBlackPawnAfterWhiteMove(){
        Game game = new Game();
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "a2-a4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "b7-b5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
    }

    @Test
    public void testInvalidInput(){
        Game game = new Game();
        String str = "asdafhjkahjk";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "asdafhjkahjk";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "a0-b0";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "a2-a0";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "i2-i4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "a2-g2";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        str = "AA-AA";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
    }
}
