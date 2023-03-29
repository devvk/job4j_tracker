package ru.job4j.strategy;

public class PaintMain {
    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }

    public static void main(String[] args) {
        PaintMain context = new PaintMain();
        context.draw(new Triangle());
        context.draw(new Square());
    }
}
