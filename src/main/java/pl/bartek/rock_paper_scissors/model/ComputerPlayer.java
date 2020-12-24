package pl.bartek.rock_paper_scissors.model;

import java.util.Random;

public class ComputerPlayer extends Player{

    public ComputerPlayer() {
        super();
    }

    @Override
    public void setMove(Move move) {
        Random random = new Random();
        int moveOrd = random.nextInt(3);
        setCurrentMove(Move.values()[moveOrd]);
    }

}
