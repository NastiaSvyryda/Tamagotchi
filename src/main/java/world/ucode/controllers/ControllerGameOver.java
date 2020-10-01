package world.ucode.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import world.ucode.scenes.GameMenu;

public class ControllerGameOver extends Controller{
    public ControllerGameOver(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    private void HandleRestart() {
        GameMenu menu = new GameMenu(primaryStage);
    }
    @FXML
    private void HandleExit() {
        System.exit(0);
    }
    @FXML
    Button RestartButton;
    @FXML
    Button ExitButton;
    @FXML
    private void EnteredRestart() {
        RestartButton.setStyle(styleHover);
    }
    @FXML
    private void ExitedRestart() {
        RestartButton.setStyle(style);
    }
    @FXML
    private void EnteredExit() {
        ExitButton.setStyle(styleHover);
    }
    @FXML
    private void ExitedExit() {
        ExitButton.setStyle(style);
    }
}
