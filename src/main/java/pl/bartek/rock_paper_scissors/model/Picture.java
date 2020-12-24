package pl.bartek.rock_paper_scissors.model;

import javafx.scene.image.Image;

import java.io.File;


public class Picture {
    public static final String rockPicture = "src/main/resources/images/rock.png";
    public static final String paperPicture = "src/main/resources/images/paper.png";
    public static final String scisorsPicture = "src/main/resources/images/scissors.png";
    public static final String emptyPicture = "src/main/resources/images/empty.png";

    public static Image getImage(String name){
        String path = null;
        switch (name){
            case "rock":
                path = rockPicture;
                break;
            case "paper":
                path = paperPicture;
                break;
            case "scissors":
                path = scisorsPicture;
                break;
            default:
                path = emptyPicture;
        }
        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        return image;
    }


}
