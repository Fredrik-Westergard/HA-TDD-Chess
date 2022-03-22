package ax.ha.tdd.chess.engine;

public enum WinningState {
    NOTSTARTED(0),
    PLAYING(1),
    CHECK(2),
    CHECKMATE(4);

    private int number;

    WinningState(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

}
