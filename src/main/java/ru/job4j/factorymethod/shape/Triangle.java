package ru.job4j.factorymethod.shape;

public class Triangle implements Shape {
    private final double a;
    private final double b;

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "   *" + ln
                + "  * *" + ln
                + " *   *" + ln
                + "*******";
    }

    @Override
    public double square() {
        return 0.5 * a * b;
    }
}
