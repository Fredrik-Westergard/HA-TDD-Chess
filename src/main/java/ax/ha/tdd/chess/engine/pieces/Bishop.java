package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Bishop extends ChessPiece{
    public Bishop(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        if(chessboard.getPiece(destination) == null){
            return isClearDiagonal(chessboard, destination);
        }
        else{
            if(chessboard.getPiece(destination).getPlayer() != player){
                return isClearDiagonal(chessboard, destination);
            }
        }

        return false;
    }

    private boolean isClearDiagonal(Chessboard chessboard, Coordinates destination){
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
}
