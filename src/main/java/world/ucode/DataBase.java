package world.ucode;

import java.sql.*;

public class DataBase {
    public static Connection Connection;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        Connection = null;
        Class.forName("org.sqlite.JDBC");
        Connection = DriverManager.getConnection("jdbc:sqlite:Tamagotchi.s3db");

        System.out.println("База Подключена!");
    }

    // --------Создание таблицы--------
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = Connection.createStatement();
        statmt.execute("CREATE TABLE if not exists 'minions' ('type' text, 'name' text, 'health' DOUBLE , 'happiness' DOUBLE, 'hunger' DOUBLE , 'thirst' DOUBLE, 'cleanliness' DOUBLE);");

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public static void WriteDB(String type, String name, double health, double happiness, double hunger, double thirst, double cleanliness) throws SQLException
    {
        statmt.execute("INSERT INTO 'minions' ('type', 'name', 'health', 'happiness', 'hunger', 'thirst', 'cleanliness') VALUES ('"+type+"', '"+name+"', "+health+", "+happiness+", "+hunger+", "+thirst+", "+cleanliness+"); ");

        System.out.println("Таблица заполнена");
    }

    // -------- Вывод таблицы--------
    public static ResultSet ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM minions");
//        while(resSet.next())
//        {
//            System.out.println( "type = " + resSet.getString("type") );
//            System.out.println( "name = " + resSet.getString("name") );
//            System.out.println( "health = " + resSet.getString("health") );
//            System.out.println( "happiness = " + resSet.getString("happiness") );
//            System.out.println( "hunger = " + resSet.getString("hunger") );
//            System.out.println( "thirst = " + resSet.getString("thirst") );
//            System.out.println( "cleanliness = " + resSet.getString("cleanliness") );
//            System.out.println();
//        }
//
//        System.out.println("Таблица выведена");
        return resSet;
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        Connection.close();
        statmt.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }
}
