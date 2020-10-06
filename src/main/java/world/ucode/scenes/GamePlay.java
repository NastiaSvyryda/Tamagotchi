package world.ucode.scenes;

import javafx.stage.Stage;
import world.ucode.controllers.ControllerGamePlay;
import world.ucode.pet.Minion;

public class GamePlay extends GameScene {
    public GamePlay(Stage primaryStage, Minion minion) {
        super(primaryStage, "/GamePlay.fxml", new ControllerGamePlay(primaryStage, minion));
    }
}
