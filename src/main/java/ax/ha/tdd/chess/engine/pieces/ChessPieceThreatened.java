package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class ChessPieceThreatened {

    public boolean isThreatened(Chessboard chessboard, Coordinates coordinates, Player player) {

        for(int i = -2; i < 3; i++){
            if(i != 0){
                if(i == 2 || i == -2){
                    if(coordinates.getY()-1 >= 0 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)) {
                        if (chessboard.getPiece(new Coordinates(coordinates.getX() + i, coordinates.getY() - 1)) != null) {
                            if (chessboard.getPiece(new Coordinates(
                                    coordinates.getX() + i, coordinates.getY() - 1)).getPlayer() !=
                                    player) {
                                return true;
                            }
                        }
                    }
                    else if(coordinates.getY()+1 <= 7 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)){
                        if(chessboard.getPiece(new Coordinates(coordinates.getX()+i, coordinates.getY()+1)) != null){
                            if(chessboard.getPiece(new Coordinates(
                                    coordinates.getX()+i, coordinates.getY()+1)).getPlayer() !=
                                    player){
                                return true;
                            }
                        }
                    }
                }
                else{
                    if(coordinates.getY()-2 >= 0 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)) {
                        if (chessboard.getPiece(new Coordinates(coordinates.getX() + i, coordinates.getY() - 2)) != null) {
                            if (chessboard.getPiece(new Coordinates(
                                    coordinates.getX() + i, coordinates.getY() - 2)).getPlayer() !=
                                    player) {
                                return true;
                            }
                        }
                    }
                    else if(coordinates.getY()+2 <= 7 && (coordinates.getX()+i >= 0 && coordinates.getX()+i <= 7)){
                        if(chessboard.getPiece(new Coordinates(coordinates.getX()+i, coordinates.getY()+2)) != null){
                            if(chessboard.getPiece(new Coordinates(
                                    coordinates.getX()+i, coordinates.getY()+2)).getPlayer() !=
                                    player){
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
