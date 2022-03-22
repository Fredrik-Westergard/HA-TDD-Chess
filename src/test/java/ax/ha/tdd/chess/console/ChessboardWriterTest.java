package ax.ha.tdd.chess.console;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChessboardWriterTest {

    @Test
    public void print_emptyChessboard_printsOkay() {
        final String expectedChessboard=
        "     A    B    C    D    E    F    G    H   \n" +
        "   +----------------------------------------+\n" +
        "8  |  *    *    *    *    *    *    *    *  |\n" +
        "   |                                        |\n" +
        "7  |  *    *    *    *    *    *    *    *  |\n" +
        "   |                                        |\n" +
        "6  |  *    *    *    *    *    *    *    *  |\n" +
        "   |                                        |\n" +
        "5  |  *    *    *    *    *    *    *    *  |\n" +
        "   |                                        |\n" +
        "4  |  *    *    *    *    *    *    *    *  |\n" +
        "   |                                        |\n" +
        "3  |  *    *    *    *    *    *    *    *  |\n" +
        "   |                                        |\n" +
        "2  |  *    *    *    *    *    *    *    *  |\n" +
        "   |                                        |\n" +
        "1  |  *    *    *    *    *    *    *    *  |\n" +
        "   +----------------------------------------+";
        Assertions.assertEquals(expectedChessboard, new ChessboardWriter().print(new Chessboard()));
    }

    @Test
    public void print_chessboardWithSinglePawn_printsOkay() {
        final String expectedChessboard=
                "     A    B    C    D    E    F    G    H   \n" +
                "   +----------------------------------------+\n" +
                "8  |  *    *    *    *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "7  |  *    *    *    *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "6  |  *    *    *    *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "5  |  *    *    *    *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "4  |  *    *   B-P   *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "3  |  *    *    *    *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "2  |  *    *    *    *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "1  |  *    *    *    *    *    *    *    *  |\n" +
                "   +----------------------------------------+";
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new ChessPieceStub(PieceType.PAWN, Player.BLACK, new Coordinates(2, 4)));
        Assertions.assertEquals(expectedChessboard, new ChessboardWriter().print(chessboard));
    }

    @Test
    public void print_fullChessboard_printsOkay() {
        final String expectedChessboard=
                "     A    B    C    D    E    F    G    H   \n" +
                "   +----------------------------------------+\n" +
                "8  | B-R  B-K  B-B  B-Q  B-K  B-B  B-K  B-R |\n" +
                "   |                                        |\n" +
                "7  | B-P  B-P  B-P  B-P  B-P  B-P  B-P  B-P |\n" +
                "   |                                        |\n" +
                "6  |  *    *    *    *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "5  |  *    *    *    *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "4  |  *    *    *    *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "3  |  *    *    *    *    *    *    *    *  |\n" +
                "   |                                        |\n" +
                "2  | W-P  W-P  W-P  W-P  W-P  W-P  W-P  W-P |\n" +
                "   |                                        |\n" +
                "1  | W-R  W-K  W-B  W-Q  W-K  W-B  W-K  W-R |\n" +
                "   +----------------------------------------+";
        final Chessboard chessboard = Chessboard.startingBoard();

        Assertions.assertEquals(expectedChessboard, new ChessboardWriter().print(chessboard));
    }
}
