package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private boolean canInsertDentures;

    public Dentist(String name, String surname, String education, String birthday,
                   boolean canGiveInjections, boolean canInsertDentures) {
        super(name, surname, education, birthday, canGiveInjections);
        this.canInsertDentures = canInsertDentures;
    }
    
    public boolean getCanInsertDentures() {
        return canInsertDentures;
    }
}
