package world.ucode.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import world.ucode.pet.Minion;
import world.ucode.pet.PetAction;
import world.ucode.pet.PetType;
import world.ucode.scenes.GamePlay;

import java.lang.reflect.InvocationTargetException;

public class ControllerGamePlay extends Controller{
    Minion minion;
    public ControllerGamePlay(Stage primaryStage, Minion minion) {
        super(primaryStage);
        this.minion = minion;
    }

    @FXML
    private void HandlePlay() throws InvocationTargetException, IllegalAccessException {
        minion.ActionHandler(PetAction.PLAY, minion);
    }

    @FXML
    private void HandleFeed() throws InvocationTargetException, IllegalAccessException {
        minion.ActionHandler(PetAction.FEED, minion);
    }

    @FXML
    private void HandleGiveWater() throws InvocationTargetException, IllegalAccessException {
        minion.ActionHandler(PetAction.GIVE_WATER, minion);
    }

    @FXML
    private void HandleGiveMedicine() throws InvocationTargetException, IllegalAccessException {
        minion.ActionHandler(PetAction.GIVE_MEDICINE, minion);
    }

    @FXML
    private void HandleCleanUp() throws InvocationTargetException, IllegalAccessException {
        minion.ActionHandler(PetAction.CLEAN_UP, minion);
    }
}
