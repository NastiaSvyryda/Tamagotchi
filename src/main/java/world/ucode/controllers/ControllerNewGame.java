package world.ucode.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import world.ucode.pet.Minion;
import world.ucode.pet.PetType;
import world.ucode.scenes.GameMenu;
import world.ucode.scenes.GamePlay;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerNewGame extends Controller{
    public ControllerNewGame(Stage primaryStage) {
        super(primaryStage);
    }
    @FXML
    TextField InputName;
    GamePlay game;

    @FXML
    private void HandleBob() {
        String name = InputName.getText();
        if (name.length() != 0)
            game = new GamePlay(primaryStage, new Minion(PetType.BOB, name));
    }

    @FXML
    private void HandleKevin() {
        String name = InputName.getText();
        if (name.length() != 0)
            game = new GamePlay(primaryStage, new Minion(PetType.KEVIN, name));
    }

    @FXML
    private void HandleStuart() {
        String name = InputName.getText();
        if (name.length() != 0)
            game = new GamePlay(primaryStage, new Minion(PetType.STUART, name));
    }

    @FXML
    private void HandleBackNewGame() {
        GameMenu menu = new GameMenu(primaryStage);
    }

    @FXML
    Button BackNewGame;
    @FXML
    Button Bob;
    @FXML
    Button Kevin;
    @FXML
    Button Stuart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BackNewGame.setOnMouseEntered(e -> BackNewGame.setStyle(styleHover));
        BackNewGame.setOnMouseExited(e -> BackNewGame.setStyle(style));
        Bob.setOnMouseEntered(e -> Bob.setStyle(styleHover));
        Bob.setOnMouseExited(e -> Bob.setStyle(style));
        Kevin.setOnMouseEntered(e -> Kevin.setStyle(styleHover));
        Kevin.setOnMouseExited(e -> Kevin.setStyle(style));
        Stuart.setOnMouseEntered(e -> Stuart.setStyle(styleHover));
        Stuart.setOnMouseExited(e -> Stuart.setStyle(style));
    }
}
