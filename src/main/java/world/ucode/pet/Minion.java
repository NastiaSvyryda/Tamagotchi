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
            name = Minion.getString("name");
            health = Double.parseDouble(Minion.getString("health"));
            happiness = Double.parseDouble(Minion.getString("happiness"));
            hunger = Double.parseDouble(Minion.getString("hunger"));
            thirst = Double.parseDouble(Minion.getString("thirst"));
            cleanliness = Double.parseDouble(Minion.getString("cleanliness"));
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

    public String GetName() {
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
        if (GetHealth() > 0) {
            SetHappiness(GetHappiness() - 0.005);
            SetHunger(GetHunger() - 0.005);
            SetThirst(GetThirst() - 0.005);
            SetCleanliness(GetCleanliness() - 0.005);
            SetHealth(GetHealth() - 0.005);
            return 0;
        }
        return -1;
    }
    private void play() {
        SetHappiness(GetHappiness() + 1);
        SetHunger(GetHunger() - 0.5);
        SetThirst(GetThirst() - 0.5);
        SetCleanliness(GetCleanliness() - 0.5);
        SetHealth(GetHealth() - 0.5);
    }
    private void feed() {
        SetHunger(GetHunger() + 1);
        SetHealth(GetHealth() + 1);
    }
    private void giveWater() {
        SetThirst(GetThirst() + 1);
        SetHealth(GetHealth() + 1);
    }
    private void giveMadicine() {
        SetHealth(GetHealth() + 1);
    }
    private void cleanUp() {
        SetCleanliness(GetCleanliness() + 1);
    }
    public void SetHealth(double value) {
        health = value;
    }
    public void SetHappiness(double value) {
        if (value < 1)
            SetHealth(GetHealth() - 0.05);
        else
            happiness = value;
    }
    public void SetHunger(double value) {
        if (value < 1)
            SetHealth(GetHealth() - 0.05);
        else
            hunger = value;
    }
    public void SetThirst(double value) {
        if (value < 1)
            SetHealth(GetHealth() - 0.05);
        else
            thirst = value;
    }
    public void SetCleanliness(double value) {
        if (value < 1)
            SetHealth(GetHealth() - 0.05);
        else
            cleanliness = value;
    }
}
