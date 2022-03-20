package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Game;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {
    @Test
    public void testKnightMoveValid(){
        Game game = new Game();
        game.move("b1-a3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("b8-c6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("a3-c4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("c6-b4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
    }

    @Test
    public void testKnightMoveInvalid(){
        Game game = new Game();
        game.move("b1-b3");
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("b1-d2");
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("b1-d3");
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("b1-d1");
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
    }

    @Test
    public void testKnightEatKnight(){
        Game game = new Game();
        game.move("b1-a3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("b8-c6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("a3-c4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("c6-e5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("c4-e5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
    }
}
