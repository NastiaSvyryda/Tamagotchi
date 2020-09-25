package world.ucode.scenes;

import javafx.stage.Stage;
import world.ucode.controllers.ControllerGameMenu;

public class GameMenu extends GameScene {
    public GameMenu(Stage primaryStage) {
        super(primaryStage, "/GameMenu.fxml", new ControllerGameMenu(primaryStage));
    }
}
