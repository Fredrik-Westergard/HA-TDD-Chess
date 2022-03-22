package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPieceThreatened;

public class WinningStateChecker {
    public static WinningState checkState(Chessboard chessboard, Player player){

        if(ChessPieceThreatened.isThreatened(chessboard, chessboard.getKing(player), player)){
            return WinningState.CHECK;
        }

        return WinningState.PLAYING;
    }
}
