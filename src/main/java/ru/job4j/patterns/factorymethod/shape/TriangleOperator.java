package ru.job4j.patterns.factorymethod.shape;

import java.util.Scanner;

public class TriangleOperator extends ShapeOperator {
    private final Scanner input = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.print("Введите длину основания треугольника: ");
        int a = Integer.parseInt(input.nextLine());
        System.out.print("Введите высоту треугольника: ");
        int b = Integer.parseInt(input.nextLine());
        return new Triangle(a, b);
    }
}
