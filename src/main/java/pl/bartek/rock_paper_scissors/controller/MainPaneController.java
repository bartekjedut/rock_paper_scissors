package pl.bartek.rock_paper_scissors.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.bartek.rock_paper_scissors.model.Game;
import pl.bartek.rock_paper_scissors.model.Move;

public class MainPaneController {

    @FXML
    private TextField tourNumberTextFied;

    @FXML
    private Button nextTourButton;

    @FXML
    private Button scissorsButton;

    @FXML
    private Button paperButton;

    @FXML
    private Button rockButton;

    @FXML
    private ImageView playerImageView;

    @FXML
    private ImageView computerImageView;

    @FXML
    private TextField scoreTextField;

    @FXML
    private TextArea winnerTextArea;

    @FXML
    private Button newGameButton;

    private Game game;

    public void initialize() {
        tourNumberTextFied.setText("10");
        newGame();
        configureNextTourButton();
        configureNewGameButton();
        configureRockPaperScissorsButtons();
        configureTourNumberTextField();
    }

    public void newGame(){
        int tours;
        try{
        tours = Integer.parseInt(tourNumberTextFied.getText());
        } catch (NumberFormatException e){
            tourNumberTextFied.setText("10");
            tours = 10;
        }
        game = new Game(tours);
        setPicturesAndTextFields();
    }

    public void configureRockPaperScissorsButtons(){
        scissorsButton.setOnAction(action -> chooseScissors());
        rockButton.setOnAction(action -> chooseRock());
        paperButton.setOnAction(action -> choosePaper());
        setPicturesAndTextFields();
    }

    public void configureNextTourButton(){
        nextTourButton.setOnAction(action -> nextTour());
    }

    public void configureNewGameButton(){
        newGameButton.setOnAction(action -> newGame());
    }

    public void configureTourNumberTextField(){
        tourNumberTextFied.setOnKeyTyped(action -> newGame());
    }

    public void chooseRock(){
        game.performTour(Move.ROCK);
        setPicturesAndTextFields();
    }

    public void choosePaper(){
        game.performTour(Move.PAPER);
        setPicturesAndTextFields();
    }

    public void chooseScissors(){
        game.performTour(Move.SCISSORS);
        setPicturesAndTextFields();
    }

    public void nextTour(){
        game.clearTour();
        setPicturesAndTextFields();
    }

    public void setPicturesAndTextFields(){
        playerImageView.setImage(game.getHumanPlayer().getCurrentMove().getImage());
        computerImageView.setImage(game.getComputerPlayer().getCurrentMove().getImage());
        scoreTextField.setText(game.getScore());
        winnerTextArea.setText(game.getLastTourWinner());
    }

}
