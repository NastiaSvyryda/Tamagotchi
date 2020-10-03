package world.ucode.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import world.ucode.scenes.GameMenu;

import java.net.URL;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RestartButton.setOnMouseEntered(e -> RestartButton.setStyle(styleHover));
        RestartButton.setOnMouseExited(e -> RestartButton.setStyle(style));
        ExitButton.setOnMouseEntered(e -> ExitButton.setStyle(styleHover));
        ExitButton.setOnMouseExited(e -> ExitButton.setStyle(style));
    }
}
