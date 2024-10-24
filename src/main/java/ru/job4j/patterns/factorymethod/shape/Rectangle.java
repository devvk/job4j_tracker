package ru.job4j.patterns.factorymethod.shape;

public class Rectangle implements Shape {
    private final double a;
    private final double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "******" + ln
                + "*    *" + ln
                + "*    *" + ln
                + "******";
    }

    @Override
    public double square() {
        return a * b;
    }
}
