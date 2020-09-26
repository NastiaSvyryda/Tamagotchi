package world.ucode.pet;

public enum PetType {
    STUART("Stuart"),
    KEVIN("Kevin"),
    BOB("Bob");

    private final String name;
    PetType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
