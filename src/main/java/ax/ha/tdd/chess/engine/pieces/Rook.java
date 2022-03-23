package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

//the rook class
public class Rook extends ChessPiece{
    /**
     * the rook constructor
     * @param player the color of the rook
     * @param location the coordinates of the rook
     */
    public Rook(Player player, Coordinates location) {
        super(PieceType.ROOK, player, location);
    }

    /**
     * method to check if rook can move
     * @param chessboard the current chessboard
     * @param destination the destination coordinates
     * @return returns true if rook can move, false if not
     */
    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        //if the destination is empty
        if(chessboard.getPiece(destination) == null){
            //check if the rook can move
            return new ChessPieceCommon(location).isClearHorizontal(chessboard, destination);
        }
        //if it wants to eat some piece
        else{
            //check if the piece is of a different color
            if(chessboard.getPiece(destination).getPlayer() != player){
                //check if rook can move
                return new ChessPieceCommon(location).isClearHorizontal(chessboard, destination);
            }
        }

        return false;
    }
}
