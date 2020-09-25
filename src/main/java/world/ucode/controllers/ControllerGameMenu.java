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
    private void HandleNewGame(ActionEvent event) {
        System.out.println("click new");
        NewGame scene = new NewGame(primaryStage);
    }
    @FXML
    private void HandleLoadGame(ActionEvent event) {
        System.out.println("click load");
        LoadGame scene = new LoadGame(primaryStage);
    }
}
