package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;

//class with common movement methods for bishop, rook, and queen movements, maybe should be static
public class ChessPieceCommon {

    private final Coordinates location;

    /**
     * chessPieceCommon constructor
     * @param location the starting coordinates
     */
    public ChessPieceCommon(Coordinates location) {
        this.location = location;
    }

    /**
     * method to check if the diagonal is clear, for bishop and queen movement
     * @param chessboard the current chessboard
     * @param destination the destination coordinates
     * @return true if it's clear false if not
     */
    public boolean isClearDiagonal(Chessboard chessboard, Coordinates destination){
        //if it's moving in diagonal
        if(Math.abs(location.getX() - destination.getX()) == Math.abs(location.getY() - destination.getY())) {
            //variables for reversing movement
            int reverseX = 1;
            int reverseY = 1;

            //if the piece is moving in x+ and y+, do nothing
            //if the piece is moving in x- and y-, reverse both
            if (location.getX() > destination.getX() && location.getY() > destination.getY()) {
                reverseX = -1;
                reverseY = -1;
            }
            //if the piece is moving in x+ y-, reverse y
            else if (location.getX() < destination.getX() && location.getY() > destination.getY()) {
                reverseY = -1;
            }
            //if the piece is moving in x- y+, reverse  x
            else if (location.getX() > destination.getX() && location.getY() < destination.getY()) {
                reverseX = -1;
            }

            //for loop to move the appropriate amount of spaces
            for (int i = 0; i < Math.abs(location.getX() - destination.getX())-1; i++) {
                //if there is a piece in any of the spaces, return false
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

    /**
     * method to check if horizontal or vertical is clear, for rook and queen movement
     * @param chessboard the current chessboard
     * @param destination the destination coordinates
     * @return true if clear, false if not
     */
    public boolean isClearHorizontal(Chessboard chessboard, Coordinates destination){
        //if moving in a straight line in X
        if(location.getX() == destination.getX()){
            //get a 'to' location by getting the smallest value of destination and location in Y,
            // direction for checking if it's clear doesn't matter
            int yTo = Math.min(location.getY(), destination.getY());
            //get a 'from' location by getting the largest value of destination and location in Y,
            //loop from 'from' to 'to'
            for(int yFrom = Math.max(location.getY(), destination.getY())-1;yFrom > yTo; yFrom--){
                //if there's a piece on any of the spaces, return false
                if(chessboard.getPiece(new Coordinates(location.getX(),yFrom)) != null){
                    return false;
                }
            }
            return true;
        }
        //if moving in a straight line in Y
        else if(location.getY() == destination.getY()){
            //get a 'to' location by getting the smallest value of destination and location in X,
            // direction for checking if it's clear doesn't matter
            int xTo = Math.min(location.getX(), destination.getX());
            //get a 'from' location by getting the largest value of destination and location in X,
            //loop from 'from' to 'to'
            for(int xFrom = Math.max(location.getY(), destination.getX())-1;xFrom > xTo; xFrom--){
                //if there's a piece on any of the spaces, return false
                if(chessboard.getPiece(new Coordinates(xFrom,location.getY())) != null){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
