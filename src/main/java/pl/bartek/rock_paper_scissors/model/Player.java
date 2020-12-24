package pl.bartek.rock_paper_scissors.model;

public abstract class Player {
    private int score;
    private Move currentMove;

    public Player() {
        this.score = 0;
        this.currentMove = Move.EMPTY;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Move getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(Move currentMove){
        this.currentMove = currentMove;
    }

    public abstract void setMove(Move move);
}
