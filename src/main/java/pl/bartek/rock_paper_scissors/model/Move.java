package pl.bartek.rock_paper_scissors.model;

import javafx.scene.image.Image;

public enum Move {
    ROCK("kamień", Picture.getImage("rock")),
    PAPER("papier", Picture.getImage("paper")),
    SCISSORS("nożyce", Picture.getImage("scissors")),
    EMPTY("pusty", Picture.getImage(""));


    private String description;
    private Image image;

    Move(String description, Image image) {
        this.description = description;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
