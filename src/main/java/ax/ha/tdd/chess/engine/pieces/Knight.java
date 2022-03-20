package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Knight extends ChessPiece{


    public Knight(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        if(chessboard.getPiece(destination) == null){
            return knightMovement(destination);
        }
        else{
            System.out.println("knight wants to eat a piece");
        }

        return false;
    }

    private boolean knightMovement(Coordinates destination){
        if(location.getX() == destination.getX()+1 || location.getX() == destination.getX()-1){
            return location.getY() == destination.getY()+2 || location.getY() == destination.getY()-2;
        }
        else if(location.getX() == destination.getX()+2 || location.getX() == destination.getX()-2){
            return location.getY() == destination.getY()+1 || location.getY() == destination.getY()-1;
        }
        return false;
    }
}
