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
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
//        try {
//            primaryStage.setTitle("tamagotchi");
//            GameMenu menu = new GameMenu(primaryStage);
//            //primaryStage.setScene(new Scene(root, 300, 250));
//            primaryStage.show();
//        }
//        catch(Exception e){
//            System.err.println("Exception e");
//        }
//        //DataBase data = new DataBase();
        DataBase.Conn();
        DataBase.CreateDB();
        DataBase.WriteDB("bob", "sasha", 0.7, 0.5, 0.9, 0.8, 1);
        DataBase.WriteDB("kevin", "nastia", 0.7, 0.5, 0.9, 0.8, 1);
        DataBase.WriteDB("kedfgbdbdvin", "nastia", 0.7, 0.5, 0.9, 0.8, 1);
        ResultSet resSet = DataBase.ReadDB();
        while(resSet.next())
        {
            //System.out.println( "type = " + resSet.getString("type") );
            System.out.println( "name = " + resSet.getString("name") );
            //System.out.println( "health = " + resSet.getString("health") );
            //System.out.println( "happiness = " + resSet.getString("happiness") );
            //System.out.println( "hunger = " + resSet.getString("hunger") );
            //System.out.println( "thirst = " + resSet.getString("thirst") );
            //System.out.println( "cleanliness = " + resSet.getString("cleanliness") );
            System.out.println();
        }

        System.out.println("Таблица выведена");
        DataBase.CloseDB();
    }
}
