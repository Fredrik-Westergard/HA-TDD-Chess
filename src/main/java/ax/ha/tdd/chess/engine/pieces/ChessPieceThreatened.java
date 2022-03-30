package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

//class for checking if a location is threatened by any piece
public class ChessPieceThreatened {

    /**
     * method for checking if a location is threatened by another piece
     * @param chessboard the current chessboard
     * @param coordinates the location to check
     * @param player the piece color (note: checks if the location is threatened by the opposite color)
     * @return true if threatened, false if not
     */
    public static boolean isThreatened(Chessboard chessboard, Coordinates coordinates, Player player) {
        return isThreatenedByKnight(chessboard, coordinates, player) ||
                isThreatenedDiagonally(chessboard, coordinates, player) ||
                isThreatenedHorizontally(chessboard, coordinates, player);
    }

    /**
     * method to check if location is threatened by knight
     * @param chessboard the current chessboard
     * @param coordinates the location to check
     * @param player the piece color (note: checks if the location is threatened by the opposite color)
     * @return true if threatened by knight, false if not
     */
    private static boolean isThreatenedByKnight(Chessboard chessboard, Coordinates coordinates, Player player){
        //loop from -2 - 2
        for(int i = -2; i < 3; i++){
            //skip 0
            if(i != 0){
                //check for x in 2 or -2 position
                if(i == 2 || i == -2){
                    //y = -1, x = 2 or -2
                    if(coordinates.getY()-1 >= 0 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)) {
                        ChessPiece piece;
                        //if location is not empty
                        if ((piece = chessboard.getPiece(new Coordinates(coordinates.getX() + i, coordinates.getY() - 1))) != null) {
                            //if piece is a knight of the opposite color
                            if (piece.getPlayer() != player && piece.getPieceType() == PieceType.KNIGHT) {
                                return true;
                            }
                        }
                    }
                    //y = 1, x = 2 or -2
                    if(coordinates.getY()+1 <= 7 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)){
                        ChessPiece piece;
                        //if location is not empty
                        if((piece = chessboard.getPiece(new Coordinates(coordinates.getX()+i, coordinates.getY()+1))) != null){
                            //if piece is a knight of the opposite color
                            if(piece.getPlayer() != player && piece.getPieceType() == PieceType.KNIGHT){
                                return true;
                            }
                        }
                    }
                }
                //if x is 1 or -1
                else{
                    //y = -2, x = 1 or -1
                    if(coordinates.getY()-2 >= 0 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)) {
                        ChessPiece piece;
                        //if location is not empty
                        if((piece = chessboard.getPiece(new Coordinates(coordinates.getX()+i, coordinates.getY()-2))) != null){
                            //if piece is a knight of the opposite color
                            if(piece.getPlayer() != player && piece.getPieceType() == PieceType.KNIGHT){
                                return true;
                            }
                        }
                    }
                    //y = 2, x = 1 or -1
                    if(coordinates.getY()+2 <= 7 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)){
                        ChessPiece piece;
                        //if location is not empty
                        if((piece = chessboard.getPiece(new Coordinates(coordinates.getX()+i, coordinates.getY()+2))) != null){
                            //if piece is a knight of the opposite color
                            if(piece.getPlayer() != player && piece.getPieceType() == PieceType.KNIGHT){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * method to check straight lines
     * @param chessboard the current chessboard
     * @param coordinates the location to check
     * @param player the piece color (note: checks if the location is threatened by the opposite color)
     * @return true if threatened, false if not
     */
    private static boolean isThreatenedHorizontally(Chessboard chessboard, Coordinates coordinates, Player player){
        //check in y+
        for(int y = coordinates.getY()+1; y < 8; y++){
            ChessPiece piece;
            //if there is a chess piece there
            if((piece = chessboard.getPiece(new Coordinates(coordinates.getX(),y))) != null){
                //and if it's a king, queen or rook in the opposite color, location is threatened, return true
                if(piece.getPlayer() != player && ((piece.getPieceType() == PieceType.KING && y == coordinates.getY()+1) ||
                        (piece.getPieceType() == PieceType.QUEEN || piece.getPieceType() == PieceType.ROOK))){
                    return true;
                }
                //else break, since only knights can skip pieces
                else{
                    break;
                }
            }
        }
        //check in y-
        for(int y = coordinates.getY()-1; y > -1; y--){
            ChessPiece piece;
            //if there is a chess piece there
            if((piece = chessboard.getPiece(new Coordinates(coordinates.getX(),y))) != null){
                //and if it's a king, queen or rook in the opposite color, location is threatened, return true
                if(piece.getPlayer() != player && ((piece.getPieceType() == PieceType.KING && y == coordinates.getY()-1) ||
                        (piece.getPieceType() == PieceType.QUEEN || piece.getPieceType() == PieceType.ROOK))){
                    return true;
                }
                //else break, since only knights can skip pieces
                else{
                    break;
                }
            }
        }
        //check in x+
        for(int x = coordinates.getX()+1; x < 8; x++){
            ChessPiece piece;
            //if there is a chess piece there
            if((piece = chessboard.getPiece(new Coordinates(x,coordinates.getY()))) != null){
                //and if it's a king, queen or rook in the opposite color, location is threatened, return true
                if(piece.getPlayer() != player&& ((piece.getPieceType() == PieceType.KING && x == coordinates.getX()+1) ||
                        (piece.getPieceType() == PieceType.QUEEN || piece.getPieceType() == PieceType.ROOK))){
                    return true;
                }
                //else break, since only knights can skip pieces
                else{
                    break;
                }
            }
        }
        //check in x-
        for(int x = coordinates.getX()-1; x > -1; x--){
            ChessPiece piece;
            //if there is a chess piece there
            if((piece = chessboard.getPiece(new Coordinates(x, coordinates.getY()))) != null){
                //and if it's a king, queen or rook in the opposite color, location is threatened, return true
                if(piece.getPlayer() != player&& ((piece.getPieceType() == PieceType.KING && x == coordinates.getX()-1) ||
                        (piece.getPieceType() == PieceType.QUEEN || piece.getPieceType() == PieceType.ROOK))){
                    return true;
                }
                //else break, since only knights can skip pieces
                else{
                    break;
                }
            }
        }
        return false;
    }

    /**
     * method to check if location is threatened diagonally
     * @param chessboard the current chessboard
     * @param coordinates the location to check
     * @param player the piece color (note: checks if the location is threatened by the opposite color)
     * @return true if threatened, false if not
     */
    private static boolean isThreatenedDiagonally(Chessboard chessboard, Coordinates coordinates, Player player){
        //note/question: not sure which way would be faster/less resource intensive to do, diagonally or horizontal.
        //there are more loops in horizontally and only one in diagonally.
        //but horizontally only loops as many times as it needs to, while diagonally always goes through 1-7
        //so if the location to check is completely blocked in horizontally would loop 0 times, right?
        //But diagonally would still do all 7. but if the piece is in the corner of the field and there's no other
        //pieces there, horizontally would loop 0+0+7+7= 14 times while diagonally would loop only 7 times?
        //Also, would starting for loops and the amount of if statements in them have an effect
        //on speed or resources? I could test it, and this program isn't built to be the fastest or most efficient anyway...

        //obstacle in the way flags
        boolean[] obstacle = {false,false,false,false};

        //main loop, loops through 1-7
        for(int i = 1; i < 8; i++){
            ChessPiece piece;
            //if y is within the board
            if(coordinates.getY()+i < 8){
                //and there's no obstacle
                if(!obstacle[0]){
                    //if x is within the board
                    if(coordinates.getX()+i < 8){
                        //if there is a piece in the way
                        if((piece = chessboard.getPiece(new Coordinates(coordinates.getX()+i, coordinates.getY()+i))) != null){
                            //and it's a pawn, bishop or queen of the opposite color, return true
                            if(piece.getPlayer() != player && ((((player == Player.BLACK &&
                                    piece.getPieceType() == PieceType.PAWN) ||
                                    (piece.getPieceType() == PieceType.KING)) && i == 1) ||
                                    (piece.getPieceType() == PieceType.BISHOP ||
                                    piece.getPieceType() == PieceType.QUEEN))){
                                return true;
                            }
                            //else flip obstacle flag
                            else{
                                obstacle[0] = true;
                            }
                        }
                    }
                }
                //if there's no obstacle
                if(!obstacle[1]) {
                    //if x is within the board
                    if (coordinates.getX() - i > -1) {
                        //if there is a piece in the way
                        if ((piece = chessboard.getPiece(new Coordinates(coordinates.getX() - i, coordinates.getY() + i))) != null) {
                            //and it's a pawn, bishop or queen of the opposite color, return true
                            if (piece.getPlayer() != player && ((((player == Player.BLACK &&
                                    piece.getPieceType() == PieceType.PAWN) ||
                                    (piece.getPieceType() == PieceType.KING)) && i == 1) ||
                                    (piece.getPieceType() == PieceType.BISHOP ||
                                    piece.getPieceType() == PieceType.QUEEN))) {
                                return true;
                            }
                            //else flip obstacle flag
                            else{
                                obstacle[1] = true;
                            }
                        }
                    }
                }
            }
            //if y is within the board
            if(coordinates.getY()-i > -1){
                //if there is no obstacle
                if(!obstacle[2]) {
                    //if x is within the board
                    if (coordinates.getX() + i < 8) {
                        //if there's a piece in the way
                        if ((piece = chessboard.getPiece(new Coordinates(coordinates.getX() + i, coordinates.getY() - i))) != null) {
                            //and it's a pawn, bishop or queen of the opposite color, return true
                            if (piece.getPlayer() != player && ((((player == Player.WHITE &&
                                    piece.getPieceType() == PieceType.PAWN) ||
                                    (piece.getPieceType() == PieceType.KING)) && i == 1) ||
                                    (piece.getPieceType() == PieceType.BISHOP ||
                                    piece.getPieceType() == PieceType.QUEEN))) {
                                return true;
                            }
                            //else flip obstacle flag
                            else {
                                obstacle[2] = true;
                            }
                        }
                    }
                }
                //if there is no obstacle
                if(!obstacle[3]) {
                    //if x is within the board
                    if (coordinates.getX() - i > -1) {
                        //if there's a piece in the way
                        if ((piece = chessboard.getPiece(new Coordinates(coordinates.getX() - i, coordinates.getY() - i))) != null) {
                            //and it's a pawn, bishop or queen of the opposite color, return true
                            if (piece.getPlayer() != player && ((((player == Player.WHITE &&
                                    piece.getPieceType() == PieceType.PAWN) ||
                                    (piece.getPieceType() == PieceType.KING)) && i == 1) ||
                                    (piece.getPieceType() == PieceType.BISHOP ||
                                    piece.getPieceType() == PieceType.QUEEN))) {
                                return true;
                            }
                            //else flip obstacle flag
                            else {
                                obstacle[3] = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
