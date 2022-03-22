package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class ChessPieceThreatened {

    public static boolean isThreatened(Chessboard chessboard, Coordinates coordinates, Player player) {
        return isThreatenedByKnight(chessboard, coordinates, player) ||
                isThreatenedDiagonally(chessboard, coordinates, player) ||
                isThreatenedHorizontally(chessboard, coordinates, player);
    }

    private static boolean isThreatenedByKnight(Chessboard chessboard, Coordinates coordinates, Player player){
        for(int i = -2; i < 3; i++){
            if(i != 0){
                if(i == 2 || i == -2){
                    //y = -1, x = 2 | -2
                    if(coordinates.getY()-1 >= 0 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)) {
                        ChessPiece piece;
                        if ((piece = chessboard.getPiece(new Coordinates(coordinates.getX() + i, coordinates.getY() - 1))) != null) {
                            if (piece.getPlayer() != player && piece.getPieceType() == PieceType.KNIGHT) {
                                return true;
                            }
                        }
                    }
                    //y = 1, x = 2 | -2
                    if(coordinates.getY()+1 <= 7 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)){
                        ChessPiece piece;
                        if((piece = chessboard.getPiece(new Coordinates(coordinates.getX()+i, coordinates.getY()+1))) != null){
                            if(piece.getPlayer() != player && piece.getPieceType() == PieceType.KNIGHT){
                                return true;
                            }
                        }
                    }
                }
                else{
                    //y = -2, x = 1 | -1
                    if(coordinates.getY()-2 >= 0 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)) {
                        ChessPiece piece;
                        if((piece = chessboard.getPiece(new Coordinates(coordinates.getX()+i, coordinates.getY()-2))) != null){
                            if(piece.getPlayer() != player && piece.getPieceType() == PieceType.KNIGHT){
                                return true;
                            }
                        }
                    }
                    //y = 2, x = 1 | -1
                    if(coordinates.getY()+2 <= 7 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)){
                        ChessPiece piece;
                        if((piece = chessboard.getPiece(new Coordinates(coordinates.getX()+i, coordinates.getY()+2))) != null){
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

    private static boolean isThreatenedHorizontally(Chessboard chessboard, Coordinates coordinates, Player player){
        for(int y = coordinates.getY()+1; y < 8; y++){
            ChessPiece piece;
            if((piece = chessboard.getPiece(new Coordinates(coordinates.getX(),y))) != null){
                if(piece.getPlayer() != player && ((piece.getPieceType() == PieceType.KING && y == coordinates.getY()+1) ||
                        (piece.getPieceType() == PieceType.QUEEN || piece.getPieceType() == PieceType.ROOK))){
                    return true;
                }
                else{
                    break;
                }
            }
        }
        for(int y = coordinates.getY()-1; y > -1; y--){
            ChessPiece piece;
            if((piece = chessboard.getPiece(new Coordinates(coordinates.getX(),y))) != null){
                if(piece.getPlayer() != player && ((piece.getPieceType() == PieceType.KING && y == coordinates.getY()-1) ||
                        (piece.getPieceType() == PieceType.QUEEN || piece.getPieceType() == PieceType.ROOK))){
                    return true;
                }
                else{
                    break;
                }
            }
        }
        for(int x = coordinates.getX()+1; x < 8; x++){
            ChessPiece piece;
            if((piece = chessboard.getPiece(new Coordinates(x,coordinates.getY()))) != null){
                if(piece.getPlayer() != player&& ((piece.getPieceType() == PieceType.KING && x == coordinates.getX()+1) ||
                        (piece.getPieceType() == PieceType.QUEEN || piece.getPieceType() == PieceType.ROOK))){
                    return true;
                }
                else{
                    break;
                }
            }
        }
        for(int x = coordinates.getX()-1; x > -1; x--){
            ChessPiece piece;
            if((piece = chessboard.getPiece(new Coordinates(x, coordinates.getY()))) != null){
                if(piece.getPlayer() != player&& ((piece.getPieceType() == PieceType.KING && x == coordinates.getX()-1) ||
                        (piece.getPieceType() == PieceType.QUEEN || piece.getPieceType() == PieceType.ROOK))){
                    return true;
                }
                else{
                    break;
                }
            }
        }
        return false;
    }

    private static boolean isThreatenedDiagonally(Chessboard chessboard, Coordinates coordinates, Player player){

        boolean[] obstacle = {false,false,false,false};

        for(int i = 1; i < 7; i++){
            ChessPiece piece;
            if(coordinates.getY()+i < 8){
                if(!obstacle[0]){
                    if(coordinates.getX()+i < 8){
                        if((piece = chessboard.getPiece(new Coordinates(coordinates.getX()+i, coordinates.getY()+i))) != null){
                            if(piece.getPlayer() != player && ((piece.getPieceType() == PieceType.PAWN && i == 1) ||
                                    (piece.getPieceType() == PieceType.BISHOP || piece.getPieceType() == PieceType.QUEEN))){
                                return true;
                            }
                            else{
                                obstacle[0] = true;
                            }
                        }
                    }
                }
                if(!obstacle[1]) {
                    if (coordinates.getX() - i > -1) {
                        if ((piece = chessboard.getPiece(new Coordinates(coordinates.getX() - i, coordinates.getY() + i))) != null) {
                            if (piece.getPlayer() != player && ((piece.getPieceType() == PieceType.PAWN && i == 1) ||
                                    (piece.getPieceType() == PieceType.BISHOP || piece.getPieceType() == PieceType.QUEEN))) {
                                return true;
                            }
                            else{
                                obstacle[1] = true;
                            }
                        }
                    }
                }
            }
            if(coordinates.getY()-i > -1){
                if(!obstacle[2]) {
                    if (coordinates.getX() + i < 8) {
                        if ((piece = chessboard.getPiece(new Coordinates(coordinates.getX() + i, coordinates.getY() - i))) != null) {
                            if (piece.getPlayer() != player && ((piece.getPieceType() == PieceType.PAWN && i == 1) ||
                                    (piece.getPieceType() == PieceType.BISHOP || piece.getPieceType() == PieceType.QUEEN))) {
                                return true;
                            } else {
                                obstacle[2] = true;
                            }
                        }
                    }
                }
                if(!obstacle[3]) {
                    if (coordinates.getX() - i > -1) {
                        if ((piece = chessboard.getPiece(new Coordinates(coordinates.getX() - i, coordinates.getY() - i))) != null) {
                            if (piece.getPlayer() != player && ((piece.getPieceType() == PieceType.PAWN && i == 1) ||
                                    (piece.getPieceType() == PieceType.BISHOP || piece.getPieceType() == PieceType.QUEEN))) {
                                return true;
                            } else {
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
