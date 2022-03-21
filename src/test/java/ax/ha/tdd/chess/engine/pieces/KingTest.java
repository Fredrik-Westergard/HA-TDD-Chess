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

    @Test
    public void testKingMoveInvalid(){
        Game game = new Game();
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        String str = "e1-e2";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "e2-e4";
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
        str = "e2-g4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "e2-e4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
    }

    @Test
    public void testKingEatPawn(){
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
        str = "d5-e4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "e2-e3";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "f7-f5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "e3-e4";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        str = "a7-a5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "e4-f5";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
    }

    @Test
    public void testCastling(){
        Game game = new Game();
        game.move("g2-g4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("d7-d5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("f1-h3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("b8-a6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("g1-f3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("d8-d6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("O-O");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("c8-e6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("a2-a4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("O-O-O");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
    }

    @Test
    public void testInvalidCastling(){
        Game game = new Game();
        game.move("g2-g4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("d7-d5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("f1-h3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("b8-a6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("g1-f3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("d8-d6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("h1-g1");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("c8-e6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("O-O");
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("a2-a3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("a8-b8");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("a3-a4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("O-O-O");
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);

        game = new Game();
        game.move("g2-g4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("d7-d5");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("g1-f3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("d8-d6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("O-O");
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("f1-h3");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("c8-e6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("a2-a4");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("O-O-O");
        assertEquals(game.getLastMoveResult(), "Last move was unsuccessful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("b8-a6");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        game.move("O-O");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.BLACK);
        game.move("O-O-O");
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
    }
}
