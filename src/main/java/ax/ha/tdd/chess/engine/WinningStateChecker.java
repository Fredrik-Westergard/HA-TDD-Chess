package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceThreatened;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class WinningStateChecker {
    public static WinningState checkState(Chessboard chessboard, Player player){

        if(checkForCheckMate(chessboard,player)){
            return WinningState.CHECKMATE;
        }

        if(ChessPieceThreatened.isThreatened(chessboard, chessboard.getKing(player), player)){
            return WinningState.CHECK;
        }

        return WinningState.PLAYING;
    }

    private static boolean checkForCheckMate(Chessboard chessboard, Player player){

        if(ChessPieceThreatened.isThreatened(chessboard, chessboard.getKing(player), player)){
            return canMove(chessboard, player) >= 8;
        }

        return false;
    }

    private static int canMove(Chessboard chessboard, Player player){
        Coordinates king = chessboard.getKing(player);
        int blocked = 0;
        if(king.getX()-1 > -1){
            if(chessboard.getPiece(new Coordinates(king.getX()-1, king.getY())) != null){
                blocked++;
            }
            else if(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(king.getX()-1, king.getY()), player)){
                blocked++;
            }
            if(king.getY()-1 > -1){
                if(chessboard.getPiece(new Coordinates(king.getX()-1, king.getY()-1)) != null){
                    blocked++;
                }
                else if(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(king.getX()-1, king.getY()-1), player)){
                    blocked++;
                }
            }
            else{
                blocked++;
            }
            if(king.getY()+1 < 8){
                if(chessboard.getPiece(new Coordinates(king.getX()-1, king.getY()+1)) != null){
                    blocked++;
                }
                else if(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(king.getX()-1, king.getY()+1), player)){
                    blocked++;
                }
            }
            else{
                blocked++;
            }
        }
        else{
            blocked+=3;
        }
        if(king.getX()+1 < 8){
            if(chessboard.getPiece(new Coordinates(king.getX()+1, king.getY())) != null){
                blocked++;
            }
            else if(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(king.getX()+1, king.getY()), player)){
                blocked++;
            }
            if(king.getY()-1 > -1){
                if(chessboard.getPiece(new Coordinates(king.getX()+1, king.getY()-1)) != null){
                    blocked++;
                }
                else if(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(king.getX()+1, king.getY()-1), player)){
                    blocked++;
                }
            }
            else{
                blocked++;
            }
            if(king.getY()+1 < 8){
                if(chessboard.getPiece(new Coordinates(king.getX()+1, king.getY()+1)) != null){
                    blocked++;
                }
                else if(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(king.getX()+1, king.getY()+1), player)){
                    blocked++;
                }
            }
            else{
                blocked++;
            }
        }
        else{
            blocked+=3;
        }
        if(king.getY()-1 > -1){
            if(chessboard.getPiece(new Coordinates(king.getX(), king.getY()-1)) != null){
                blocked++;
            }
            else if(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(king.getX(), king.getY()-1), player)){
                blocked++;
            }
        }
        else{
            blocked++;
        }
        if(king.getY()+1 < 8){
            if(chessboard.getPiece(new Coordinates(king.getX(), king.getY()+1)) != null){
                blocked++;
            }
            else if(ChessPieceThreatened.isThreatened(chessboard, new Coordinates(king.getX(), king.getY()+1), player)){
                blocked++;
            }
        }
        else{
            blocked++;
        }
        return blocked;
    }
}
