module rock.paper.scissors {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports pl.bartek.rock_paper_scissors.app to javafx.graphics;
    opens pl.bartek.rock_paper_scissors.controller to javafx.fxml;
}