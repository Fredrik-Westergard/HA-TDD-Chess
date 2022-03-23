package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Bishop extends ChessPiece{
    /**
     * bishop piece constructor
     * @param player the color of the bishop
     * @param location the coordinates of the bishop
     */
    public Bishop(Player player, Coordinates location) {
        super(PieceType.BISHOP, player, location);
    }

    /**
     * method to check if bishop can move from current location to destination
     * @param chessboard current chessboard
     * @param destination the destination
     * @return true if it can move, false if not
     */
    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        if(chessboard.getPiece(destination) == null){
            return new ChessPieceCommon(location).isClearDiagonal(chessboard, destination);
        }
        else{
            if(chessboard.getPiece(destination).getPlayer() != player){
                return new ChessPieceCommon(location).isClearDiagonal(chessboard, destination);
            }
        }

        return false;
    }
}
