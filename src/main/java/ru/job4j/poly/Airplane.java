package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("fly");
    }

    @Override
    public void type() {
        System.out.println(getClass().getSimpleName());
    }
}
