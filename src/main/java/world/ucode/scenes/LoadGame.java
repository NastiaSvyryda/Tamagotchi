package world.ucode.scenes;

import javafx.stage.Stage;
import world.ucode.controllers.ControllerLoadGame;

public class LoadGame extends GameScene {
    public LoadGame(Stage primaryStage) {
        super(primaryStage, "LoadGame.fxml", new ControllerLoadGame(primaryStage));
    }
}
