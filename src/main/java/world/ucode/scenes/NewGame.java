package world.ucode.scenes;

import javafx.stage.Stage;
import world.ucode.controllers.ControllerNewGame;

public class NewGame extends GameScene {
    public NewGame(Stage primaryStage) {
        super(primaryStage, "/NewGame.fxml", new ControllerNewGame(primaryStage));
    }
}
