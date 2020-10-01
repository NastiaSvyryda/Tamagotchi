package world.ucode.scenes;

import javafx.stage.Stage;
import world.ucode.controllers.ControllerGameOver;

public class GameOver extends GameScene {
    public GameOver(Stage primaryStage) {
        super(primaryStage, "/GameOver.fxml", new ControllerGameOver(primaryStage));
    }
}
