package world.ucode.pet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Minion {
    private String name;
    private PetType type;
    private int maxHealth = 100;

    private int health = 10;
    private int happiness = 10;
    private int hunger = 0;
    private int thirst = 0;
    private int cleanliness = 10;
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

    public void StartAnimation() {

    }
    public void ActionHandler(PetAction action, Minion minion) throws InvocationTargetException, IllegalAccessException {
        actions.get(action).invoke(minion);
    }

    public String getName() {
        return name;
    }

    private void play() {
        System.out.println("play");
        happiness++;
        hunger++;
        thirst++;
        cleanliness--;
        health--;
    }
    private void feed() {
        System.out.println("feed");
        hunger--;
        health++;
    }
    private void giveWater() {
        System.out.println("give water");
        thirst--;
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
