package ax.ha.tdd.chess.console;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;

public class ChessboardWriter {

    public String print(final Chessboard chessboard) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < 9 ; y++) {
            for (int x = 0; x < 9 ; x++) {
                if(y == 0 || x == 0) {
                    if(y == 0 && x == 0){
                        stringBuilder.append("    ");
                    }
                    else if(y == 0){
                        stringBuilder.append(" ");
                        stringBuilder.append(((char)(64+x)));
                        stringBuilder.append("   ");
                    }
                    else{
                        if(y == 1){
                            stringBuilder.append("\n");
                        }
                        stringBuilder.append(y);
                        stringBuilder.append("  | ");
                    }
                }
                else{
                    final ChessPiece chessPiece = chessboard.getPiece(new Coordinates(x-1, y-1));
                    if (chessPiece == null) {
                        stringBuilder.append(" * ");
                    } else {
                        stringBuilder.append(chessPiece.getPlayer().getSymbol())
                                .append("-")
                                .append(chessPiece.getSymbol());
                    }

                    if (x < 8) {
                        stringBuilder.append("  ");
                    }
                }
            }
            if(y == 0){
                stringBuilder.append("\n");
            }
            else {
                stringBuilder.append(" |\n");
            }
            if (y < 8) {
                if(y == 0){
                    stringBuilder.append("   +----------------------------------------+");
                }
                else {
                    stringBuilder.append("   |                                        |\n");
                }
            }
        }
        stringBuilder.append("   +----------------------------------------+");
        return stringBuilder.toString();
    }
}
