package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

//knight class
public class Knight extends ChessPiece{

    /**
     * the constructor for knight
     * @param player the color of the knight
     * @param location the coordinates of the knight
     */
    public Knight(Player player, Coordinates location) {
        super(PieceType.KNIGHT, player, location);
    }

    /**
     * method to check if knight can move
     * @param chessboard the current chessboard
     * @param destination the destination coordinates
     * @return true if the knight can move to the destination, false if not
     */
    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        //if destination is empty
        if(chessboard.getPiece(destination) == null){
            return knightMovement(destination);
        }
        //if it's trying to eat something
        else{
            //if it's of a different color
            if(chessboard.getPiece(destination).getPlayer() != getPlayer()){
                return knightMovement(destination);
            }
        }

        return false;
    }

    /**
     * method to check if the knight can move to a specific spot
     * @param destination the destination to check
     * @return true if it's a valid movement, false if not
     */
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
