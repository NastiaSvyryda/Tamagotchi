package world.ucode.pet;

public enum PetAction {
    PLAY("Play"),
    FEED("Eat"),
    GIVE_WATER("Drink"),
    GIVE_MEDICINE("Medicine"),
    CLEAN_UP("Shower");

    private final String name;
    PetAction(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
