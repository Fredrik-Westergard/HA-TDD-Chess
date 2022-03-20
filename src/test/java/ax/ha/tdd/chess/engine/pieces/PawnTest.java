package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Game;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

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

    @Test
    public void testWhitePawnEatBlackPawn(){
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
    }
}
