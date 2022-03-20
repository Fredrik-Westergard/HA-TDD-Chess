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
