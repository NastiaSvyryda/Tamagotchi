package world.ucode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.ucode.scenes.GameMenu;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        try {
            DataBase.Conn();
            DataBase.CreateDB();
            primaryStage.setTitle("tamagotchi");
            GameMenu menu = new GameMenu(primaryStage);
            //primaryStage.setScene(new Scene(root, 300, 250));
            primaryStage.show();
            //DataBase.CloseDB();
        }
        catch(Exception e){
            System.err.println("Exception");
        }
//        DataBase.WriteDB("kevin", "nastia", 0.7, 0.5, 0.9, 0.8, 1);
//        DataBase.WriteDB("kedfgbdbdvin", "nastia", 0.7, 0.5, 0.9, 0.8, 1);
//        ResultSet resSet = DataBase.ReadDB();
    }
}
