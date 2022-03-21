package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Queen extends ChessPiece{
    public Queen(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        if(chessboard.getPiece(destination) == null){
            if(Math.abs(location.getY()- destination.getY()) == Math.abs(location.getX()-destination.getX())){
                return new ChessPieceCommon(location).isClearDiagonal(chessboard, destination);
            }
            else{
                return new ChessPieceCommon(location).isClearHorizontal(chessboard, destination);
            }
        }
        else{
            System.out.println("Queen wants to eat a piece");
        }

        return false;
    }
}
