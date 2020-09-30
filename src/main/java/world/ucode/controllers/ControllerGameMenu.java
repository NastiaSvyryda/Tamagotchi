package world.ucode.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import world.ucode.scenes.LoadGame;
import world.ucode.scenes.NewGame;

public class ControllerGameMenu extends Controller{
    public ControllerGameMenu(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    private void HandleNewGame() {
        System.out.println("click new");
        NewGame scene = new NewGame(primaryStage);
    }
    @FXML
    private void HandleLoadGame() {
        System.out.println("click load");
        LoadGame scene = new LoadGame(primaryStage);
    }

    @FXML
    Button NewGameButton;
    @FXML
    Button LoadGameButton;
    public void EnteredNewGame() {
        NewGameButton.setStyle(styleHover);
    }
    public void ExitedNewGame() {
        NewGameButton.setStyle(style);
    }
    public void EnteredLoadGame() {
        LoadGameButton.setStyle(styleHover);
    }
    public void ExitedLoadGame() {
        LoadGameButton.setStyle(style);
    }
}
