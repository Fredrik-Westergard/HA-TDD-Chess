package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

// the queen piece
public class Queen extends ChessPiece{
    /**
     * the queens constructor
     * @param player the color of the piece
     * @param location the current coordinates
     */
    public Queen(Player player, Coordinates location) {
        super(PieceType.QUEEN, player, location);
    }

    /**
     * method to check if the queen can move to destination
     * @param chessboard the current chessboard
     * @param destination the destination coordinates
     * @return true if it can move, false if not
     */
    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        //if the destination is empty
        if(chessboard.getPiece(destination) == null){
            //if it's moving diagonally
            if(Math.abs(location.getY()- destination.getY()) == Math.abs(location.getX()-destination.getX())){
                //check if it's clear to move
                return new ChessPieceCommon(location).isClearDiagonal(chessboard, destination);
            }
            //if it's moving straight
            else{
                //check if it's clear to move
                return new ChessPieceCommon(location).isClearHorizontal(chessboard, destination);
            }
        }
        //if it wants to eat another piece
        else{
            //if the piece is of a different color
            if(chessboard.getPiece(destination).getPlayer() != player){
                //if it's moving diagonally
                if(Math.abs(location.getY()- destination.getY()) == Math.abs(location.getX()-destination.getX())){
                    //if it's clear to move
                    return new ChessPieceCommon(location).isClearDiagonal(chessboard, destination);
                }
                //if it's moving straight
                else{
                    //if it's clear to move
                    return new ChessPieceCommon(location).isClearHorizontal(chessboard, destination);
                }
            }
        }

        return false;
    }
}
