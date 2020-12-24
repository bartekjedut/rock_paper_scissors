package pl.bartek.rock_paper_scissors.model;

public class Game {
    private static final String computerWinner = "WYGRYWA KOMPUTER";
    private static final String humanWinner = "WYGRYWA GRACZ";
    private static final String draw = "REMIS";
    private static final String endOfGameMessage = "KONIEC GRY";
    private boolean tourPerformed;
    private int tourNumbers;
    private int currentTour;
    private String lastTourWinner;
    private String score;
    private Player humanPlayer;
    private Player computerPlayer;

    public Game(int tourNumbers) {
        this.tourPerformed = false;
        this.tourNumbers = tourNumbers;
        this.currentTour = 1;
        this.lastTourWinner = "";
        this.score = "0/0";
        this.humanPlayer = new HumanPlayer();
        this.computerPlayer = new ComputerPlayer();
    }

    public String getLastTourWinner() {
        return lastTourWinner;
    }

    public String getScore() {
        return score;
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public Player getComputerPlayer() {
        return computerPlayer;
    }

    public void performTour(Move move){
        if(currentTour <= tourNumbers && tourPerformed == false){
            humanPlayer.setMove(move);
            computerPlayer.setMove(Move.EMPTY);
            if(chceckPlayerWins()){
                humanPlayer.setScore(humanPlayer.getScore() + 1);
                lastTourWinner = humanWinner;
            } else if (checkDraw()) {
                lastTourWinner = draw;
            } else {
                computerPlayer.setScore(computerPlayer.getScore() + 1);
                lastTourWinner = computerWinner;
            }
            currentTour++;
            score = humanPlayer.getScore() + "/" + computerPlayer.getScore();
            tourPerformed = true;
        }
    }

    public void clearTour(){
        if(currentTour > tourNumbers){
            if(humanPlayer.getScore() > computerPlayer.getScore()){
                lastTourWinner = endOfGameMessage + "\n" + humanWinner;
            } else if(humanPlayer.getScore() == computerPlayer.getScore()){
                lastTourWinner = endOfGameMessage +"\n" + draw;
            } else {
                lastTourWinner = endOfGameMessage + "\n" + computerWinner;
            }
        } else {
            tourPerformed = false;
            humanPlayer.setCurrentMove(Move.EMPTY);
            computerPlayer.setCurrentMove(Move.EMPTY);
            lastTourWinner = "";
        }
    }

    private boolean chceckPlayerWins(){
        if(humanPlayer.getCurrentMove().equals(Move.PAPER) && computerPlayer.getCurrentMove().equals(Move.ROCK)){
            return true;
        }
        if(humanPlayer.getCurrentMove().equals(Move.ROCK) && computerPlayer.getCurrentMove().equals(Move.SCISSORS)){
            return true;
        }
        if(humanPlayer.getCurrentMove().equals(Move.SCISSORS) && computerPlayer.getCurrentMove().equals(Move.PAPER)){
            return true;
        }
        return false;
    }

    private boolean checkDraw(){
        if(humanPlayer.getCurrentMove().equals(Move.PAPER) && computerPlayer.getCurrentMove().equals(Move.PAPER)){
            return true;
        }
        if(humanPlayer.getCurrentMove().equals(Move.ROCK) && computerPlayer.getCurrentMove().equals(Move.ROCK)){
            return true;
        }
        if(humanPlayer.getCurrentMove().equals(Move.SCISSORS) && computerPlayer.getCurrentMove().equals(Move.SCISSORS)){
            return true;
        }
        return false;
    }

}
