package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class King extends ChessPiece {

    public King(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        if(Math.abs(location.getX()-destination.getX()) <= 1 || Math.abs(location.getY()-destination.getY()) <= 1){
            if(chessboard.getPiece(destination) == null){
                return true;
            }
            else{
                return chessboard.getPiece(destination).getPlayer() != player;
            }
        }
        return false;
    }
}
