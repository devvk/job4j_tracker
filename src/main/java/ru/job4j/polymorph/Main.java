package ru.job4j.polymorph;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new SportCar();
        car.changeGear();
        car.accelerate();
        car.steer();
        car.brake();
        car.refill();
        car.testMethod();
        Vehicle.getDragCoefficient();
        car.chargeBattery();
        System.out.println(Vehicle.FUEL_PRICE);
    }
}
