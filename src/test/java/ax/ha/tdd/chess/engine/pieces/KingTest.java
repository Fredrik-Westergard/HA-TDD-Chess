package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Game;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingTest {
    @Test
    public void testKingMoveValid(){
        Game game = new Game();
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "e2-e4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "d7-d5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "e1-e2";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "d5-d4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "e2-f3";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
    }

}
