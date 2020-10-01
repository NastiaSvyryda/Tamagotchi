package world.ucode.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLoadGame implements Initializable {
    @FXML
    ChoiceBox<String> LoadMinions;
    protected String style = "-fx-background-color:yellow;";
    protected String styleHover = "-fx-background-color:yellow;-fx-border-color: black; -fx-border-radius: 3px;-fx-border-width : 1px";
    protected Stage primaryStage;
    public ControllerLoadGame(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void HandleSelect() {
        String selectedChoice = LoadMinions.getSelectionModel().getSelectedItem();
        System.out.println(selectedChoice);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("hello");
        ObservableList<String> availableChoices = FXCollections.observableArrayList("apples", "oranges");
        LoadMinions.setItems(availableChoices);
    }
}
