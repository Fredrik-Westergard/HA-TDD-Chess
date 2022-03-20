package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Game;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RookTest {
    @Test
    public void testIsMoveRookValid(){
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
        str = "a4-b5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a7-a6";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "a1-a3";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
    }

    @Test
    public void testIsMoveRookInvalid(){
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
        str = "a4-b5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a8-b3";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a8-b8";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a8-b3";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a8-h1";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
    }

    @Test
    public void testRookHasObstacle(){
        Game game = new Game();
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "a1-a4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "a2-a4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a8-a3";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a8-a1";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
    }

    @Test
    public void testRookEatRook(){
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
        str = "a4-b5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "h7-h6";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "a1-a7";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a8-a7";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
    }
}
