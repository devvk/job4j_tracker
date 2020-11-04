package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("move on rails");
    }

    @Override
    public void type() {
        System.out.println(getClass().getSimpleName());
    }
}
