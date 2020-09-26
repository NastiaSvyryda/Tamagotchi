package world.ucode.pet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Mionion {
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
            put(PetAction.PLAY, Mionion.class.getDeclaredMethod("play"));
            put(PetAction.FEED, Mionion.class.getDeclaredMethod("feed"));
            put(PetAction.GIVE_WATER, Mionion.class.getDeclaredMethod("giveWater"));
            put(PetAction.GIVE_MEDICINE, Mionion.class.getDeclaredMethod("giveMadicine"));
            put(PetAction.CLEAN_UP, Mionion.class.getDeclaredMethod("cleanUp"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }};

    public Mionion(PetType type) {
        this.type = type;
        this.name = type.toString();
    }
//    public Pet(String bdName) {
//
//    }
    public void ActionHandler(PetAction action) throws InvocationTargetException, IllegalAccessException {
        actions.get(action).invoke(null);
    }

    public String getName() {
        return name;
    }

    private void play() {
        happiness++;
        hunger++;
        thirst++;
        cleanliness--;
        health--;
    }
    private void feed() {
        hunger--;
        health++;
    }
    private void giveWater() {
        thirst--;
        health++;
    }
    private void giveMadicine() {
        health++;
    }
    private void cleanUp() {
        cleanliness++;
    }
}
