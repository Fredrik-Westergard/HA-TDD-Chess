package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;

import java.util.Iterator;
import java.util.List;

public class Chessboard implements Iterable<ChessPiece[]> {
    // This could just as easily be replaced with a List or Set,
    // since the ChessPieces right now keep track of their own location.
    // Feel free to change this however you like
    // [y][x]
    private final ChessPiece[][] board = new ChessPiece[8][8];
    //the kings
    private King[] king = new King[2];

    /**
     * getter for king
     * @param player the color of king you want
     * @return the King object
     */
    public King getKing(Player player) {
        if(player == Player.WHITE){
            return king[0];
        }
        else{
            return king[1];
        }
    }

    /**
     * setter of king object
     * @param coordinates the coordinates of the king
     * @param player the color of the king
     */
    public void setKing(Coordinates coordinates, Player player) {
        king[player == Player.WHITE?0:1] = (King)this.getPiece(coordinates);
    }

    /**
     * Method to get starting chessboard
     * @return the starting chessboard
     */
    public static Chessboard startingBoard() {
        final Chessboard chessboard = new Chessboard();

        chessboard.addAllPieces();
        return chessboard;
    }

    /**
     * getter for a specific piece
     * @param coordinates the coordinates for that piece
     * @return the piece or null
     */
    public ChessPiece getPiece(final Coordinates coordinates) {
        return board[coordinates.getY()][coordinates.getX()];
    }

    /**
     * method to add piece to the board
     * @param chessPiece the chess piece to add
     */
    public void addPiece(final ChessPiece chessPiece) {
        board[chessPiece.getLocation().getY()][chessPiece.getLocation().getX()] = chessPiece;
    }

    /**
     * method to remove chesspiece
     * @param chessPiece the chess piece to remove
     */
    public void removePiece(final ChessPiece chessPiece){
        board[chessPiece.getLocation().getY()][chessPiece.getLocation().getX()] = null;
    }

    /**
     * Method to add all pieces in correct positions
     */
    private void addAllPieces() {
        for(int yCoordinate = 0; yCoordinate < 2; yCoordinate++){
            for(int xCoordinate = 0; xCoordinate < 8; xCoordinate++){
                if(yCoordinate == 1){
                    addPiece(new Pawn(Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new Pawn(Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
                else if((xCoordinate == 0 || xCoordinate == 7)){
                    addPiece(new Rook(Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new Rook(Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
                else if((xCoordinate == 1 || xCoordinate == 6)){
                    addPiece(new Knight(Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new Knight(Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
                else if((xCoordinate == 2 || xCoordinate == 5)){
                    addPiece(new Bishop(Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new Bishop(Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
                else if(xCoordinate == 3){
                    addPiece(new Queen(Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new Queen(Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
                else{
                    king[0] = new King(Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate));
                    king[1] = new King(Player.BLACK, new Coordinates(xCoordinate, yCoordinate));
                    addPiece(king[0]);
                    addPiece(king[1]);
                }
            }
        }
    }

    @Override
    public Iterator<ChessPiece[]> iterator() {
        return List.of(board).iterator();
    }
}
