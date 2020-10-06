package world.ucode.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import world.ucode.DataBase;
import world.ucode.pet.Minion;
import world.ucode.pet.PetAction;
import world.ucode.scenes.GameMenu;
import world.ucode.animation.MinionAnimation;
import world.ucode.scenes.GameOver;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerGamePlay extends Controller{
    Minion minion;
    MinionAnimation animation;
    Timeline LiveCycle;
    @FXML
    ImageView AnimationView;
    @FXML
    ImageView MinionView;
    @FXML
    Label MinionName;

    public ControllerGamePlay(Stage primaryStage, Minion minion) {
        super(primaryStage);
        this.minion = minion;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::HandleClose);
        ButtonSetStyle();
        MinionName.setText(minion.GetType().toString());
        MinionName.setAlignment(Pos.TOP_CENTER);
        this.animation = new MinionAnimation(minion.GetType(),AnimationView, MinionView);
        startLiveCycle();
    }

    private void HandleClose(WindowEvent event){
        LiveCycle.stop();
        SaveMinion();
    }

    private void SaveMinion(){
        try {
            DataBase.WriteDB(minion.GetType().toString(), minion.GetName(), minion.GetHealth(), minion.GetHappiness(),
                    minion.GetHunger(), minion.GetThirst(), minion.GetCleanliness());;
        }
        catch (SQLException ignored) {
            System.err.println("SQLException");
        }
    }
    private void SetProgress() {
        ProgressBarHealth.setProgress(minion.GetHealth()/minion.GetMaxHealth());
        ProgressBarHappiness.setProgress(minion.GetHappiness()/10);
        ProgressBarHunger.setProgress(minion.GetHunger()/10);
        ProgressBarThirst.setProgress(minion.GetThirst()/10);
        ProgressBarCleanliness.setProgress(minion.GetCleanliness()/10);
    }
    @FXML
    private void HandleBackGamePlay() {
        LiveCycle.stop();
        SaveMinion();
        GameMenu menu = new GameMenu(primaryStage);
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
                            try {
                                DataBase.DeleteDB(minion.GetName());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            LiveCycle.stop();
                            GameOver menu = new GameOver(primaryStage);
                        }
                        SetProgress();
                    }
                }));
        LiveCycle.play();
    }

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
    private void ButtonSetStyle() {
        BackGamePlay.setOnMouseEntered(e -> BackGamePlay.setStyle(styleHover));
        BackGamePlay.setOnMouseExited(e -> BackGamePlay.setStyle(style));
        PlayButton.setOnMouseEntered(e -> PlayButton.setStyle(styleHover));
        PlayButton.setOnMouseExited(e -> PlayButton.setStyle(style));
        FeedButton.setOnMouseEntered(e -> FeedButton.setStyle(styleHover));
        FeedButton.setOnMouseExited(e -> FeedButton.setStyle(style));
        GiveWaterButton.setOnMouseEntered(e -> GiveWaterButton.setStyle(styleHover));
        GiveWaterButton.setOnMouseExited(e -> GiveWaterButton.setStyle(style));
        GiveMedicineButton.setOnMouseEntered(e -> GiveMedicineButton.setStyle(styleHover));
        GiveMedicineButton.setOnMouseExited(e -> GiveMedicineButton.setStyle(style));
        CleanUpButton.setOnMouseEntered(e -> CleanUpButton.setStyle(styleHover));
        CleanUpButton.setOnMouseExited(e -> CleanUpButton.setStyle(style));
    }
}
