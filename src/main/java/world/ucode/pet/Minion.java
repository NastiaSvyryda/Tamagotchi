package world.ucode.pet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    public Minion(PetType type) {
        this.type = type;
        this.name = type.toString();
    }
//    public Pet(String bdName) {
//
//    }

//    public void StartAnimation() {
//
//    }
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
