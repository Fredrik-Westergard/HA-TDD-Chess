package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;

import java.util.Objects;
import java.util.regex.Pattern;

public class Game {

    Chessboard board = Chessboard.startingBoard();
    boolean lastMove = false;

    //Feel free to delete this stuff. Just for initial testing.
    boolean isNewGame = true;

    public Player getPlayerToMove() {
        //TODO this should reflect the current state.
        return Player.WHITE;
    }

    public Chessboard getBoard() {
        return board;
    }

    public String getLastMoveResult() {
        //TODO this should be used to show the player what happened
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
        //TODO this should trigger your move logic.
        lastMove = false;
        move = move.toUpperCase();

        if(Objects.equals(move, "O-O")){
            System.out.println("king side castling");
        }
        else if(Objects.equals(move, "O-O-O")){
            System.out.println("queen side castling");
        }
        else if(Pattern.matches("[A-H][0-8]-[A-H][0-8]", move)){
            Coordinates start = new Coordinates(move.charAt(0)-65, 8-(move.charAt(1)-48));
            Coordinates end = new Coordinates(move.charAt(3)-65, 8-(move.charAt(4)-48));
            ChessPiece piece = board.getPiece(start);

            if(piece != null){
                if(piece.getPlayer() == this.getPlayerToMove()){
                    if(piece.canMove(board,end)){
                        board.removePiece(piece);
                        piece.setLocation(end);
                        board.addPiece(piece);
                        lastMove = true;
                    }
                }
            }
        }
        isNewGame = false;
        System.out.println("Player tried to perform move: " + move);
        System.out.println("And it was: " + (lastMove?"successful":"unsuccessful"));
    }
}
