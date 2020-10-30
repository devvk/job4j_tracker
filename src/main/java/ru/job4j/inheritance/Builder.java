package ru.job4j.inheritance;

public class Builder extends Engineer {

    private boolean canStatics;

    public Builder(String name, String surname, String education,
                    String birthday, boolean canPhysics, boolean canStatics) {
        super(name, surname, education, birthday, canPhysics);
        this.canStatics = canStatics;
    }

    public boolean getCanStatics() {
        return canStatics;
    }
}

