package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Rook extends ChessPiece{
    public Rook(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        if(chessboard.getPiece(destination) == null){
            return new ChessPieceCommon(location).isClearHorizontal(chessboard, destination);
        }
        else{
            if(chessboard.getPiece(destination).getPlayer() != player){
                return new ChessPieceCommon(location).isClearHorizontal(chessboard, destination);
            }
        }

        return false;
    }
}
