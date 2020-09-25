package world.ucode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.ucode.scenes.GameMenu;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("tamagotchi");
        GameMenu menu = new GameMenu(primaryStage);
        //primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
