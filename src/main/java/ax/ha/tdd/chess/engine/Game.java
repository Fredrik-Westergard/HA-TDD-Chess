package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;

import java.util.Objects;
import java.util.regex.Pattern;

public class Game {
    private Chessboard board = Chessboard.startingBoard();
    //boolean used to check if last move was successful
    private boolean lastMove = false;
    //indicator for which players move it is
    private Player playerToMove = Player.WHITE;

    //Feel free to delete this stuff. Just for initial testing.
    boolean isNewGame = true;

    public Player getPlayerToMove() {
        return playerToMove;
    }

    public void setPlayerToMove(Player p){
        this.playerToMove = p;
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
        //set last move to false to indicate that there is a new move happening
        lastMove = false;
        //change move to uppercase
        move = move.toUpperCase();

        //if king side castling
        if(Objects.equals(move, "O-O")){
            System.out.println("king side castling");
        }
        //if queen side castling
        else if(Objects.equals(move, "O-O-O")){
            System.out.println("queen side castling");
        }
        //if regular move
        else if(Pattern.matches("[A-H][0-8]-[A-H][0-8]", move)){
            //get the coordinates for start/end
            Coordinates start = new Coordinates(move.charAt(0)-65, 8-(move.charAt(1)-48));
            Coordinates end = new Coordinates(move.charAt(3)-65, 8-(move.charAt(4)-48));
            //get the piece to be moved
            ChessPiece piece = board.getPiece(start);

            //if there is a piece
            if(piece != null){
                //if it's a piece of the players color
                if(piece.getPlayer() == this.getPlayerToMove()){
                    //and if the piece can move, move the piece, change player and set last move to successful
                    if(piece.canMove(board,end)){
                        board.removePiece(piece);
                        piece.setLocation(end);
                        board.addPiece(piece);
                        setPlayerToMove(getPlayerToMove() == Player.WHITE ? Player.BLACK : Player.WHITE);
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
