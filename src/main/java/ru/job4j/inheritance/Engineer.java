package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean canPhysics;

    public Engineer(String name, String surname, String education,
                    String birthday, boolean canPhysics) {
        super(name, surname, education, birthday);
        this.canPhysics = canPhysics;

    }

    public boolean getCanPhysics() {
        return canPhysics;
    }
}
