package ru.job4j.polymorph;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new TownCar();
        car.changeGear();
        car.accelerate();
        car.steer();
        car.brake();
        car.refill();
        car.testMethod();
    }
}
