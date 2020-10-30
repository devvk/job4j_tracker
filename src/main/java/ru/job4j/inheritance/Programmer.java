package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private boolean canJava;

    public Programmer(String name, String surname, String education,
                    String birthday, boolean canPhysics, boolean canJava) {
        super(name, surname, education, birthday, canPhysics);
        this.canJava = canJava;
    }

    public boolean getCanJava() {
        return canJava;
    }
}
