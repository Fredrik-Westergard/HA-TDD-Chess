package ax.ha.tdd.chess.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    public void testIsMovePawnValid(){
        Game game = new Game();
        String str = "a2-a4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        game = new Game();
        str = "a2-a3";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
    }

    @Test
    public void testIsMovePawnInvalid(){
        Game game = new Game();
        String str = "a2-b4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        game = new Game();
        str = "a3-a4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        game = new Game();
        str = "a2-b5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        game = new Game();
        str = "a2-a2";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
    }

}
