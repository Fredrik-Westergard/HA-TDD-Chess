package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPieceThreatened;
import ax.ha.tdd.chess.engine.pieces.King;

//class for checking the state of winning
public class WinningStateChecker {
    /**
     * method to check for the winning state
     * @param chessboard the current chessboard
     * @param player the player to check for
     * @return the winning state
     */
    public static WinningState checkState(Chessboard chessboard, Player player){

        if(checkForCheckMate(chessboard,player)){
            return WinningState.CHECKMATE;
        }

        if(ChessPieceThreatened.isThreatened(chessboard, chessboard.getKing(player).getLocation(), player)){
            return WinningState.CHECK;
        }

        return WinningState.PLAYING;
    }

    /**
     * method to check for check mate
     * @param chessboard the current chessboard
     * @param player the player to check for
     * @return true if check mate, false if not
     */
    private static boolean checkForCheckMate(Chessboard chessboard, Player player){
        //if the king is threatened
        if(ChessPieceThreatened.isThreatened(chessboard, chessboard.getKing(player).getLocation(), player)){
            //and it can't move, it's check mate
            return canMove(chessboard, player);
        }
        return false;
    }

    /**
     * method to check if king can move out of the way
     * @param chessboard the current chessboard
     * @param player the player to check for
     * @return true if the king can move, false if not
     */
    private static boolean canMove(Chessboard chessboard, Player player){
        //get the king of the right color
        King king = chessboard.getKing(player);
        //check if it can move anywhere
        for(int i= -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if(i != 0 || j != 0){
                    if(king.getLocation().getY()+i > -1 && king.getLocation().getY()+i < 8 &&
                            king.getLocation().getX()+j > -1 && king.getLocation().getX()+j < 8){
                        if(king.canMove(chessboard,
                                new Coordinates(king.getLocation().getX()+j, king.getLocation().getY()+i))){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
