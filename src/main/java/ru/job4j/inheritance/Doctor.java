package ru.job4j.inheritance;

public class Doctor extends Profession {

    private boolean canGiveInjections;

    public Doctor(String name, String surname, String education,
                  String birthday, boolean canGiveInjections) {
        super(name, surname, education, birthday);
        this.canGiveInjections = canGiveInjections;
    }

    public boolean getCanGiveInjections() {
        return canGiveInjections;
    }
}
