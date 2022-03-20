package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Rook extends ChessPiece{
    public Rook(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        if(chessboard.getPiece(destination) == null){
            return isClearLine(chessboard, destination);
        }
        else{
            if(chessboard.getPiece(destination).getPlayer() != player){
                return isClearLine(chessboard, destination);
            }
        }

        return false;
    }

    private boolean isClearLine(Chessboard chessboard, Coordinates destination){
        if(location.getX() == destination.getX()){
            int yTo = Math.min(location.getY(), destination.getY());
            for(int yFrom = Math.max(location.getY(), destination.getY())-1;yFrom > yTo; yFrom--){
                if(chessboard.getPiece(new Coordinates(location.getX(),yFrom)) != null){
                    return false;
                }
            }
            return true;
        }
        else if(location.getY() == destination.getY()){
            int xTo = Math.min(location.getX(), destination.getX());
            for(int xFrom = Math.max(location.getY(), destination.getX())-1;xFrom > xTo; xFrom--){
                if(chessboard.getPiece(new Coordinates(xFrom,location.getY())) != null){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
