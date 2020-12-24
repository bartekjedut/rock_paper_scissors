package pl.bartek.rock_paper_scissors.model;

public class HumanPlayer extends Player{

    public HumanPlayer() {
        super();
    }

    @Override
    public void setMove (Move move){
        setCurrentMove(move);
    }
}
