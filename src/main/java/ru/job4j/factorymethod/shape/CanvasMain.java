package ru.job4j.factorymethod.shape;

import java.util.Scanner;

public class CanvasMain {
    private final ShapeOperator shapeOperator;

    public CanvasMain(ShapeOperator shapeOperator) {
        this.shapeOperator = shapeOperator;
    }

    public void demonstrate() {
        shapeOperator.showInfo();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShapeOperator operator;
        System.out.print("Какую фигуру вы хотите построить: ");
        String answer = input.nextLine();
        if ("прямоугольник".equals(answer)) {
            operator = new RectangleOperator();
        } else {
            operator = new TriangleOperator();
        }

        CanvasMain canvasMain = new CanvasMain(operator);
        canvasMain.demonstrate();
    }
}
