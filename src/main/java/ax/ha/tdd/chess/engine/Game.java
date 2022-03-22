package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.*;

import java.util.Objects;
import java.util.regex.Pattern;

public class Game {
    private Chessboard board = Chessboard.startingBoard();
    //boolean used to check if last move was successful
    private boolean lastMove = false;
    //indicator for which players move it is
    private Player playerToMove = Player.WHITE;

    private final ChessboardWriter chessboardWriter = new ChessboardWriter();

    //Feel free to delete this stuff. Just for initial testing.
    boolean isNewGame = true;

    public Player getPlayerToMove() {
        return playerToMove;
    }

    private void setPlayerToMove(Player p){
        this.playerToMove = p;
    }

    public Chessboard getBoard() {
        return board;
    }

    public String getCheckResult(){

        if(WinningStateChecker.checkState(board,Player.BLACK) == WinningState.CHECKMATE ||
            WinningStateChecker.checkState(board, Player.WHITE) == WinningState.CHECKMATE){
            return playerToMove.name().toLowerCase() + " won!";
        }
        else if(WinningStateChecker.checkState(board, Player.WHITE) == WinningState.CHECK &&
                WinningStateChecker.checkState(board,Player.BLACK) == WinningState.CHECK){
            return "White and black are in check positions";
        }
        else if(WinningStateChecker.checkState(board, Player.WHITE) == WinningState.CHECK){
            return "White is in check position";
        }
        else if(WinningStateChecker.checkState(board, Player.BLACK) == WinningState.CHECK){
            return "Black is in check position";
        }
        return "";
    }

    public String getLastMoveResult() {
        //Illegal move, correct move, e2 moved to e4 etc.
        if (isNewGame) {
            return "Game hasn't begun";
        }
        else if(lastMove){
            return "Last move was successful";
        }
        else{
            return "Last move was unsuccessful";
        }
    }

    public void move(String move) {
        if (WinningStateChecker.checkState(board, Player.WHITE) != WinningState.CHECKMATE &&
                WinningStateChecker.checkState(board, Player.BLACK) != WinningState.CHECKMATE) {
            //set last move to false, to indicate that there is a new move happening
            lastMove = false;
            //change move to uppercase
            move = move.toUpperCase();


            //if king side castling
            if (Objects.equals(move, "O-O")) {
                Coordinates rooksCoordinates = new Coordinates(7, playerToMove == Player.BLACK ? 0 : 7);
                Coordinates kingsCoordinates = new Coordinates(4, playerToMove == Player.BLACK ? 0 : 7);
                Rook rook = (Rook) board.getPiece(rooksCoordinates);
                King king = (King) board.getPiece(kingsCoordinates);
                if (rook != null && king != null) {
                    if (rook.HasNotMoved() && king.HasNotMoved()) {
                        if (king.canCastle(board, true)) {
                            board.removePiece(rook);
                            board.removePiece(king);
                            rook.setLocation(kingsCoordinates);
                            king.setLocation(rooksCoordinates);
                            king.setMoved(true);
                            rook.setMoved(true);
                            board.addPiece(rook);
                            board.addPiece(king);
                            board.setKing(rooksCoordinates, getPlayerToMove());
                            setPlayerToMove(getPlayerToMove() == Player.WHITE ? Player.BLACK : Player.WHITE);
                            lastMove = true;
                        }
                    }
                }

            }
            //if queen side castling
            else if (Objects.equals(move, "O-O-O")) {
                Coordinates rooksCoordinates = new Coordinates(0, playerToMove == Player.BLACK ? 0 : 7);
                Coordinates kingsCoordinates = new Coordinates(4, playerToMove == Player.BLACK ? 0 : 7);
                Rook rook = (Rook) board.getPiece(rooksCoordinates);
                King king = (King) board.getPiece(kingsCoordinates);

                if (rook != null && king != null) {
                    if (rook.HasNotMoved() && king.HasNotMoved()) {
                        if (king.canCastle(board, false)) {
                            board.removePiece(rook);
                            board.removePiece(king);
                            rook.setLocation(kingsCoordinates);
                            king.setLocation(rooksCoordinates);
                            king.setMoved(true);
                            rook.setMoved(true);
                            board.addPiece(rook);
                            board.addPiece(king);
                            board.setKing(rooksCoordinates, getPlayerToMove());
                            setPlayerToMove(getPlayerToMove() == Player.WHITE ? Player.BLACK : Player.WHITE);
                            lastMove = true;
                        }
                    }
                }
            }
            //if regular move
            else if (Pattern.matches("[A-H][1-8]-[A-H][1-8]", move)) {
                //get the coordinates for start/end
                Coordinates start = new Coordinates(move.charAt(0) - 65, 8 - (move.charAt(1) - 48));
                Coordinates end = new Coordinates(move.charAt(3) - 65, 8 - (move.charAt(4) - 48));
                //get the piece to be moved
                ChessPiece piece = board.getPiece(start);

                //if there is a piece
                if (piece != null) {
                    //if it's a piece of the players color
                    if (piece.getPlayer() == getPlayerToMove()) {
                        //and if the piece can move, move the piece, change player and set last move to successful
                        if (piece.canMove(board, end)) {
                            ChessPiece pieceToBeEaten;
                            if ((pieceToBeEaten = board.getPiece(end)) != null) {
                                board.removePiece(pieceToBeEaten);
                            }
                            board.removePiece(piece);
                            piece.setLocation(end);
                            board.addPiece(piece);
                            piece.setMoved(true);
                            lastMove = true;
                            if (piece.getPieceType() == PieceType.KING) {
                                board.setKing(end, getPlayerToMove());
                            }
                            if(WinningStateChecker.checkState(board,Player.WHITE) != WinningState.CHECKMATE &&
                                    WinningStateChecker.checkState(board,Player.BLACK) != WinningState.CHECKMATE ) {
                                setPlayerToMove(getPlayerToMove() == Player.WHITE ? Player.BLACK : Player.WHITE);
                            }
                        }
                    }

                }
            }
            isNewGame = false;
            System.out.println(chessboardWriter.print(board));
            System.out.println("   | " + playerToMove.name().toLowerCase() + " tried to perform move: " + move + (move.equals("O-O") ? "       |" : "     |"));
            System.out.println("   | and it was: " + (lastMove ? "successful                 |" : "unsuccessful               |"));
            if(WinningStateChecker.checkState(board,Player.WHITE) != WinningState.CHECKMATE &&
                WinningStateChecker.checkState(board,Player.BLACK) != WinningState.CHECKMATE) {
                if (WinningStateChecker.checkState(board, Player.WHITE) == WinningState.CHECK) {
                    System.out.println("   | white is in check position             |");
                }
                if (WinningStateChecker.checkState(board, Player.BLACK) == WinningState.CHECK) {
                    System.out.println("   | black is in check position             |");
                }
            }
            else{
                System.out.println("   | " + getCheckResult() +"                             |");
            }
            System.out.println("   +----------------------------------------+");
            System.out.println();
        }
        else{
            lastMove = false;
            System.out.println("Can't move after check mate");
        }
    }
}
