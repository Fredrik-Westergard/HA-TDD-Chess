package ax.ha.tdd.chess.engine;

public enum WinningState {
    PLAYING(0),
    CHECK(1),
    CHECKMATE(3);

    private final int number;

    WinningState(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

}
