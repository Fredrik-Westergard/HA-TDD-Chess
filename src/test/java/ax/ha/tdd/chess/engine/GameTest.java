package ax.ha.tdd.chess.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testChangeGameStateFromNotCheckToCheck(){
        final Game game = new Game();
        assertFalse(game.isCheck(Player.BLACK));
        game.setCheck(true, Player.BLACK);
        assertTrue(game.isCheck(Player.BLACK));
        assertFalse(game.isCheck(Player.WHITE));
        game.setCheck(true, Player.WHITE);
        assertTrue(game.isCheck(Player.WHITE));
    }

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
        assertTrue(game.isCheck(Player.BLACK));
        game.move("d4-f3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertTrue(game.isCheck(Player.WHITE));
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
        assertTrue(game.isCheck(Player.BLACK));
        game.move("d4-f3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertTrue(game.isCheck(Player.WHITE));
        game.move("f6-d5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertFalse(game.isCheck(Player.BLACK));
        game.move("f3-d4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertFalse(game.isCheck(Player.WHITE));
    }
}
