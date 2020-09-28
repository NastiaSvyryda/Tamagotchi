package world.ucode.scenes;

import javafx.stage.Stage;
import world.ucode.controllers.ControllerGamePlay;
import world.ucode.controllers.ControllerNewGame;
import world.ucode.pet.Minion;

public class GamePlay extends GameScene {
    //Minion minion;
    public GamePlay(Stage primaryStage, Minion minion) {
        super(primaryStage, "/GamePlay.fxml", new ControllerGamePlay(primaryStage, minion));
        //this.minion = minion;
    }
}
