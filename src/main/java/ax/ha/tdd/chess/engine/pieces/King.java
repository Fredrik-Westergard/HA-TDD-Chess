package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

//class for the king piece
public class King extends ChessPiece {

    /**
     * king constructor
     * @param player the color of the king
     * @param location the current coordinates
     */
    public King(Player player, Coordinates location) {
        super(PieceType.KING, player, location);
    }

    /**
     * method to check if piece can move from location to destination
     * @param chessboard the current chessboard
     * @param destination the destination
     * @return true if it can move
     */
    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        //if it's only trying to move one space
        if(Math.abs(location.getX()-destination.getX()) <= 1 || Math.abs(location.getY()-destination.getY()) <= 1){
            //if there space to move to is empty
            if(chessboard.getPiece(destination) == null){
                //remove the king to be able to properly check if that space is threatened
                chessboard.removePiece(this);
                //check if space is threatened
                boolean threatened = !ChessPieceThreatened.isThreatened(chessboard, destination, getPlayer());
                //add the king back
                chessboard.addPiece(this);
                return threatened;

            }
            //if it's trying to eat another piece
            else{
                //remove the king to be able to properly check if that space is threatened
                chessboard.removePiece(this);
                //check if piece is threatened
                boolean threatened =  (chessboard.getPiece(destination).getPlayer() != player) &&
                        !ChessPieceThreatened.isThreatened(chessboard, destination, getPlayer());
                //add the king back
                chessboard.addPiece(this);
                return threatened;
            }
        }
        return false;
    }

    /**
     * method to check if the king can castle
     * @param board the current chessboard
     * @param kingSide true for king side castling, false for queen side
     * @return true if it can castle, false if not
     */
    public boolean canCastle(Chessboard board, boolean kingSide){
        //if king has not moved
        if(hasNotMoved()) {
            //get the y location of the king
            int y = location.getY();
            //get the player of that piece
            Player player = board.getPiece(new Coordinates(4, y)).getPlayer();

            Rook rook;

            //if it's king side and the king side rook hasn't moved
            if (kingSide && (rook = (Rook) board.getPiece(new Coordinates(7, y))) != null ) {
                if((rook.hasNotMoved())) {
                    //if there's empty space between them
                    if (board.getPiece(new Coordinates(5, y)) == null && board.getPiece(new Coordinates(6, y)) == null) {
                        //if none of the spaces are threatened
                        return !(ChessPieceThreatened.isThreatened(board, new Coordinates(4, y), player) ||
                                ChessPieceThreatened.isThreatened(board, new Coordinates(5, y), player) ||
                                ChessPieceThreatened.isThreatened(board, new Coordinates(6, y), player) ||
                                ChessPieceThreatened.isThreatened(board, new Coordinates(7, y), player));
                    }
                }
            }
            //if it's queen side and the queen side rook hasn't moved
            else if((rook = (Rook) board.getPiece(new Coordinates(7, y))) != null){
                if(rook.hasNotMoved()) {
                    //if there's empty space between them
                    if (board.getPiece(new Coordinates(3, y)) == null && board.getPiece(new Coordinates(2, y)) == null &&
                            board.getPiece(new Coordinates(1, y)) == null) {
                        //if none of the spaces are threatened
                        return !(ChessPieceThreatened.isThreatened(board, new Coordinates(4, y), player) ||
                                ChessPieceThreatened.isThreatened(board, new Coordinates(3, y), player) ||
                                ChessPieceThreatened.isThreatened(board, new Coordinates(2, y), player) ||
                                ChessPieceThreatened.isThreatened(board, new Coordinates(1, y), player) ||
                                ChessPieceThreatened.isThreatened(board, new Coordinates(0, y), player));
                    }
                }
            }
        }
        return false;
    }
}
