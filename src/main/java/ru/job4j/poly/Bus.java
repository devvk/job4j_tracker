package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void move() {
        System.out.println(type() + ": drive");
    }

    @Override
    public void drive() {
        System.out.println("drive");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Number of passengers: " + number);
    }

    @Override
    public double fillUp(double number) {
        double price = 1.12;
        return number * price;
    }
}
