package world.ucode.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerNewGame extends Controller{
    @FXML
    Button Bob;
    @FXML
    Button Kevin;
    @FXML
    Button Stuart;
    public ControllerNewGame(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    private void HandleBob() {

    }

    @FXML
    private void HandleKevin() {

    }

    @FXML
    private void HandleStuart() {

    }

    @FXML
    private void EnteredBob() {
        Bob.setStyle(styleHover);
    }
    @FXML
    private void ExitedBob() {
        Bob.setStyle(style);
    }

    @FXML
    private void EnteredKevin() {
        Kevin.setStyle(styleHover);
    }
    @FXML
    private void ExitedKevin() {
        Kevin.setStyle(style);
    }

    @FXML
    private void EnteredStuart() {
        Stuart.setStyle(styleHover);
    }
    @FXML
    private void ExitedStuart() {
        Stuart.setStyle(style);
    }
}
