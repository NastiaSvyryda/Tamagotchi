package world.ucode.controllers;

import javafx.stage.Stage;

public abstract class Controller {
    Stage primaryStage;
    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
