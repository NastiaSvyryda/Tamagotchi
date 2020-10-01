package world.ucode.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import world.ucode.pet.Minion;
import world.ucode.pet.PetAction;
import world.ucode.scenes.GameMenu;
import world.ucode.animation.MinionAnimation;
import world.ucode.scenes.GameOver;

import java.lang.reflect.InvocationTargetException;

public class ControllerGamePlay extends Controller{
    Minion minion;
    MinionAnimation animation;
    Timeline LiveCycle;
    @FXML
    ImageView AnimationView;

    public ControllerGamePlay(Stage primaryStage, Minion minion) {
        super(primaryStage);
        this.minion = minion;
    }

    @FXML
    private void HandleBackGamePlay() {
        GameMenu menu = new GameMenu(primaryStage);
    }

    @FXML
    private void HandleStart() {
        //SetProgress();
        MinionName.setText(minion.getName());
        this.animation = new MinionAnimation(minion.GetType(),AnimationView);
        startLiveCycle();
    }
    private void SetProgress() {
        ProgressBarHealth.setProgress(minion.GetHealth()/minion.GetMaxHealth());
        ProgressBarHappiness.setProgress(minion.GetHappiness()/10);
        ProgressBarHunger.setProgress(minion.GetHunger()/10);
        ProgressBarThirst.setProgress(minion.GetThirst()/10);
        ProgressBarCleanliness.setProgress(minion.GetCleanliness()/10);
    }
    @FXML
    ProgressBar ProgressBarHealth;
    @FXML
    ProgressBar ProgressBarHappiness;
    @FXML
    ProgressBar ProgressBarHunger;
    @FXML
    ProgressBar ProgressBarThirst;
    @FXML
    ProgressBar ProgressBarCleanliness;
    @FXML
    Label MinionName;

    @FXML
    private void HandlePlay() throws InvocationTargetException, IllegalAccessException {
        minion.ActionHandler(PetAction.PLAY, minion);
        animation.HandleAnimation(PetAction.PLAY);
    }

    @FXML
    private void HandleFeed() throws InvocationTargetException, IllegalAccessException {
        minion.ActionHandler(PetAction.FEED, minion);
        animation.HandleAnimation(PetAction.FEED);
    }

    @FXML
    private void HandleGiveWater() throws InvocationTargetException, IllegalAccessException {
        minion.ActionHandler(PetAction.GIVE_WATER, minion);
        animation.HandleAnimation(PetAction.GIVE_WATER);
    }

    @FXML
    private void HandleGiveMedicine() throws InvocationTargetException, IllegalAccessException {
        minion.ActionHandler(PetAction.GIVE_MEDICINE, minion);
        animation.HandleAnimation(PetAction.GIVE_MEDICINE);
    }

    @FXML
    private void HandleCleanUp() throws InvocationTargetException, IllegalAccessException {
        minion.ActionHandler(PetAction.CLEAN_UP, minion);
        animation.HandleAnimation(PetAction.CLEAN_UP);
    }

    private void startLiveCycle() {
        LiveCycle = new Timeline();
        LiveCycle.setCycleCount(Timeline.INDEFINITE);

        LiveCycle.getKeyFrames().add(
                new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (minion.LiveCycle() == -1) {
                            //delete minion from db
                            LiveCycle.stop();
                            GameOver menu = new GameOver(primaryStage);
                        }
                        SetProgress();
                        System.out.println("LiveCycle");
                    }
                }));
        LiveCycle.play();
    }
    @FXML
    Button StartButton;
    @FXML
    Button BackGamePlay;
    @FXML
    Button PlayButton;
    @FXML
    Button FeedButton;
    @FXML
    Button GiveWaterButton;
    @FXML
    Button GiveMedicineButton;
    @FXML
    Button CleanUpButton;
    @FXML
    private void EnteredStart() {
        StartButton.setStyle(styleHover);
    }
    @FXML
    private void ExitedStart() {
        StartButton.setStyle(style);
    }
    @FXML
    private void EnteredBackGamePlay() {
        BackGamePlay.setStyle(styleHover);
    }
    @FXML
    private void ExitedBackGamePlay() {
        BackGamePlay.setStyle(style);
    }
    @FXML
    private void EnteredPlay() {
        PlayButton.setStyle(styleHover);
    }
    @FXML
    private void ExitedPlay() {
        PlayButton.setStyle(style);
    }
    @FXML
    private void EnteredFeed() {
        FeedButton.setStyle(styleHover);
    }
    @FXML
    private void ExitedFeed() {
        FeedButton.setStyle(style);
    }
    @FXML
    private void EnteredGiveWater() {
        GiveWaterButton.setStyle(styleHover);
    }
    @FXML
    private void ExitedGiveWater() {
        GiveWaterButton.setStyle(style);
    }
    @FXML
    private void EnteredGiveMedicine() {
        GiveMedicineButton.setStyle(styleHover);
    }
    @FXML
    private void ExitedGiveMedicine() {
        GiveMedicineButton.setStyle(style);
    }
    @FXML
    private void EnteredCleanUp() {
        CleanUpButton.setStyle(styleHover);
    }
    @FXML
    private void ExitedCleanUp() {
        CleanUpButton.setStyle(style);
    }
}
