package world.ucode.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import world.ucode.scenes.LoadGame;
import world.ucode.scenes.NewGame;

public class ControllerGameMenu extends Controller{
    @FXML
    Button NewGameButton;
    @FXML
    Button LoadGameButton;
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
    private void EnteredNewGame() {
        NewGameButton.setStyle(styleHover);
    }
    @FXML
    private void ExitedNewGame() {
        NewGameButton.setStyle(style);
    }
    @FXML
    private void EnteredLoadGame() {
        LoadGameButton.setStyle(styleHover);
    }
    @FXML
    private void ExitedLoadGame() {
        LoadGameButton.setStyle(style);
    }
}
