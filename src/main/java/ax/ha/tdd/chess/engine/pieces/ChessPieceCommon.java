package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;

public class ChessPieceCommon {

    private final Coordinates location;

    public ChessPieceCommon(Coordinates location) {
        this.location = location;
    }

    public boolean isClearDiagonal(Chessboard chessboard, Coordinates destination){
        if(Math.abs(location.getX() - destination.getX()) == Math.abs(location.getY() - destination.getY())) {
            int reverseX = 1;
            int reverseY = 1;

            if (location.getX() > destination.getX() && location.getY() > destination.getY()) {
                reverseX = -1;
                reverseY = -1;
            } else if (location.getX() < destination.getX() && location.getY() > destination.getY()) {
                reverseY = -1;
            }
            else if (location.getX() > destination.getX() && location.getY() < destination.getY()) {
                reverseX = -1;
            }

            for (int i = 0; i < Math.abs(location.getX() - destination.getX())-1; i++) {
                if (chessboard.getPiece(new Coordinates(
                        location.getX() + (i * reverseX) + reverseX,
                        location.getY() + (i * reverseY) + reverseY)) != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isClearHorizontal(Chessboard chessboard, Coordinates destination){
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
