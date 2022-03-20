package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Pawn extends ChessPiece{

    public Pawn(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        boolean moveTwoSpaces = false;

        int reverse = 1;
        if(player == Player.WHITE){
            reverse = -1;
        }

        if((location.getY() == 1 && player == Player.BLACK)||(location.getY() == 6 && player == Player.WHITE)){
            moveTwoSpaces = true;
        }

        if(chessboard.getPiece(destination) == null){
            if(location.getX() == destination.getX()){
                if(moveTwoSpaces && location.getY() == destination.getY()-(2*reverse)){
                    return chessboard.getPiece(new Coordinates(destination.getX(), destination.getY() - reverse)) == null;
                }
                else{
                    return location.getY() == destination.getY() - reverse;
                }
            }
        }
        else if(isDestinationPieceDifferentColor(chessboard, destination)){
            if(location.getX() == destination.getX()+1 || location.getX() == destination.getX()-1){
                return location.getY() == destination.getY() - reverse;
            }
        }

        return false;
    }
}
