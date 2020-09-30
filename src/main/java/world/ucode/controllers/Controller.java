package world.ucode.controllers;

import javafx.stage.Stage;

public abstract class Controller {
    protected String style = "-fx-background-color:yellow;";
    protected String styleHover = "-fx-background-color:yellow;-fx-border-color: black; -fx-border-radius: 3px;-fx-border-width : 1px";
    protected Stage primaryStage;
    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
