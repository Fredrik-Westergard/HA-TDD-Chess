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
        str = "a8-a3";
        game.move(str);
        assertEquals(game.getLastMoveResult(), "Last move was successful");
        assertEquals(game.getPlayerToMove(), Player.WHITE);
        str = "a1-a2";
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
}
