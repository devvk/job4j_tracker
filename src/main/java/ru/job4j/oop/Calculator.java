package ru.job4j.oop;

public class Calculator {
    private static final int X = 5;

    public double divide(int y) {
        return (double) y / X;
    }

    public int multiply(int y) {
        return X * y;
    }

    public static int minus(int y) {
        return y - X;
    }

    public static int sum(int y) {
        return X + y;
    }

    public double sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        int sum = Calculator.sum(5);
        System.out.println("sum: " + sum);
        int minus = Calculator.minus(15);
        System.out.println("minus: " + minus);
        Calculator calculator = new Calculator();
        int multiply = calculator.multiply(2);
        System.out.println("multiply: " + multiply);
        double divide = calculator.divide(50);
        System.out.println("divide: " + divide);
        double sumAll = calculator.sumAllOperation(5);
        System.out.println("sumAll: " + sumAll);
    }
}
