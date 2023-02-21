package ru.job4j.oop.nested;

public class Car {
    private final String brand;
    private final String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Двигатель запущен.");
    }

    public class Transmission {
        public void accelerate() {
            System.out.println("Ускорение.");
        }
    }

    public class Brakes {
        public void brake() {
            System.out.println("Торможение.");
        }
    }

    public class TripComputer {
        private final String tripData = "Бортовой компьютер";
        private final String brand = "Bosch";
        private final String model = "TC101";

        public void printInfo() {
            System.out.println(tripData);
            System.out.println("Марка TripComputer: " + this.brand);
            System.out.println("Модель TripComputer: " + this.model);
            System.out.println("Марка Car: " + Car.this.brand);
            System.out.println("Модель Car: " + Car.this.model);

        }
    }
}
