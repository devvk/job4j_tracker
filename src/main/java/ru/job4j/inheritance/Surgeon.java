package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private boolean canOperate;

    public Surgeon(String name, String surname, String education, String birthday,
                   boolean canGiveInjections, boolean canOperate) {
        super(name, surname, education, birthday, canGiveInjections);
        this.canOperate = canOperate;
    }

    public boolean getCanOperate() {
        return canOperate;
    }
}
