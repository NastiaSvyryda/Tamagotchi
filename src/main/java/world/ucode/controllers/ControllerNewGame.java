package world.ucode.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import world.ucode.pet.Minion;
import world.ucode.pet.PetType;
import world.ucode.scenes.GameMenu;
import world.ucode.scenes.GamePlay;

public class ControllerNewGame extends Controller{
    public ControllerNewGame(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    private void HandleBob() {
        GamePlay game = new GamePlay(primaryStage, new Minion(PetType.BOB));
    }

    @FXML
    private void HandleKevin() {
        GamePlay game = new GamePlay(primaryStage, new Minion(PetType.KEVIN));
    }

    @FXML
    private void HandleStuart() {
        GamePlay game = new GamePlay(primaryStage, new Minion(PetType.STUART));
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
    @FXML
    private void EnteredBackNewGame() { BackNewGame.setStyle(styleHover); }
    @FXML
    private void ExitedBackNewGame() { BackNewGame.setStyle(style); }
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
