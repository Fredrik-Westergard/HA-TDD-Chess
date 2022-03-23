package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

//pawn class
public class Pawn extends ChessPiece{

    /**
     * the pawn constructor
     * @param player the color of the pawn
     * @param location the coordinates of teh pawn
     */
    public Pawn(Player player, Coordinates location) {
        super(PieceType.PAWN, player, location);
    }

    /**
     * method to check if pawn can move
     * @param chessboard the current chessboard
     * @param destination the destination coordinates
     * @return true if ti can move, false if not
     */
    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        //flag for moving two spaces, can only move two spaces if it's in the starting position
        boolean moveTwoSpaces = ((location.getY() == 1 && player == Player.BLACK) ||
                (location.getY() == 6 && player == Player.WHITE));
        //reverser for movement
        int reverse = 1;
        if(player == Player.WHITE){
            reverse = -1;
        }

        //if the destination is empty
        if(chessboard.getPiece(destination) == null){
            //if it's moving forward
            if(location.getX() == destination.getX()){
                //if it wants to move two spaces
                if(moveTwoSpaces && location.getY() == destination.getY()-(2*reverse)){
                    //if the piece between the location and destination is empty, return true
                    return chessboard.getPiece(new Coordinates(destination.getX(), destination.getY() - reverse)) == null;
                }
                else{
                    //return true if it's moving one space forward
                    return location.getY() == destination.getY() - reverse;
                }
            }
        }
        //if it wants to eat something of a different color
        else if(chessboard.getPiece(destination).getPlayer() != getPlayer()){
            //it's moving diagonally forward and one space return true
            if(location.getX() == destination.getX()+1 || location.getX() == destination.getX()-1){
                return location.getY() == destination.getY() - reverse;
            }
        }

        return false;
    }
}
