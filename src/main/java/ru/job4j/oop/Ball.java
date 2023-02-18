package ru.job4j.oop;

public class Ball {

    public void tryRun(boolean condition) {
        String msg = condition ? "Колобок съеден!" : "Колобок сбежал...";
        System.out.println(msg);
    }
}
