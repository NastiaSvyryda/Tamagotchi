package world.ucode.pet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Minion {
    private String name;
    private PetType type;
    private double maxHealth = 10;

    private double health = 10;
    private double happiness = 10;
    private double hunger = 10;
    private double thirst = 10;
    private double cleanliness = 10;
    private final Map<PetAction, Method> actions = new HashMap<PetAction, Method>() {{
        try {
            put(PetAction.PLAY, Minion.class.getDeclaredMethod("play"));
            put(PetAction.FEED, Minion.class.getDeclaredMethod("feed"));
            put(PetAction.GIVE_WATER, Minion.class.getDeclaredMethod("giveWater"));
            put(PetAction.GIVE_MEDICINE, Minion.class.getDeclaredMethod("giveMadicine"));
            put(PetAction.CLEAN_UP, Minion.class.getDeclaredMethod("cleanUp"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }};

    public Minion(PetType type, String name) {
        this.type = type;
        this.name = name;
    }
    public Minion(ResultSet Minion) {
        try {
            type = toType(Minion.getString("type"));
            System.out.println("type = " + Minion.getString("type"));
            name = Minion.getString("name");
            System.out.println("name = " + Minion.getString("name"));
            health = Double.parseDouble(Minion.getString("health"));
            System.out.println("health = " + Minion.getString("health"));
            happiness = Double.parseDouble(Minion.getString("happiness"));
            System.out.println("happiness = " + Minion.getString("happiness"));
            hunger = Double.parseDouble(Minion.getString("hunger"));
            System.out.println("hunger = " + Minion.getString("hunger"));
            thirst = Double.parseDouble(Minion.getString("thirst"));
            System.out.println("thirst = " + Minion.getString("thirst"));
            cleanliness = Double.parseDouble(Minion.getString("cleanliness"));
            System.out.println("cleanliness = " + Minion.getString("cleanliness"));
            System.out.println();
        }
        catch(SQLException ignored) {
            System.err.println("SQLException");
        }
    }

    public PetType toType(String type) {
        if (type.equals("Stuart"))
            return PetType.STUART;
        if (type.equals("Kevin"))
            return PetType.KEVIN;
        if (type.equals("Bob"))
            return PetType.BOB;
        return null;
    }

    public void ActionHandler(PetAction action, Minion minion) throws InvocationTargetException, IllegalAccessException {
        actions.get(action).invoke(minion);
    }

    public String getName() {
        return name;
    }
    public PetType GetType() {
        return type;
    }
    public double GetMaxHealth() {return maxHealth;}
    public double GetHealth() {return health;}
    public double GetHappiness() {return happiness;}
    public double GetHunger() {return hunger;}
    public double GetThirst() {return thirst;}
    public double GetCleanliness() {return cleanliness;}

    public int LiveCycle() {
        if (health > 0) {
            happiness -= 0.005;
            hunger -= 0.005;
            thirst -= 0.005;
            cleanliness -= 0.005;
            health -= 0.005;
            return 0;
        }
        return -1;
    }
    private void play() {
        System.out.println("play");
        happiness++;
        hunger--;
        thirst--;
        cleanliness--;
        health--;
    }
    private void feed() {
        System.out.println("feed");
        hunger++;
        health++;
    }
    private void giveWater() {
        System.out.println("give water");
        thirst++;
        health++;
    }
    private void giveMadicine() {
        System.out.println("give med");
        health++;
    }
    private void cleanUp() {
        System.out.println("clean");
        cleanliness++;
    }
}
