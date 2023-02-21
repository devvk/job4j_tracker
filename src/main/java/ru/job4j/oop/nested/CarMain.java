package ru.job4j.oop.nested;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car("Audi", "A4");
        Car.Transmission transmission = car.new Transmission();
        Car.Brakes brakes = car.new Brakes();
        Car.TripComputer tripComputer = car.new TripComputer();
        car.startEngine();
        transmission.accelerate();
        brakes.brake();
        tripComputer.printInfo();
    }
}
