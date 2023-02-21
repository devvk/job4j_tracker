package ru.job4j.oop.nested;

public class Car {
    private final String brand;
    private final String model;
    private static String carManual = "Инструкция к автомобилю.";

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

    /**
     * Из статического класса Manual мы можем обращаться напрямую только к статическим
     * переменным внешнего класса, то есть только к переменной carManual.
     * Если мы хотим, например, обратиться к нестатической переменной model класса Car,
     * нам нужен объект класса Car.
     */
    public static class Manual {
        public static String getManual() {
            Car car = new Car("Audi", "Q7");
            return "Модель: " + car.model + ", Марка: " + car.brand + ", Инструкция: " + carManual;
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

    public static TripComputer getTripComputer() {
        Car car = new Car("BMW", "740i");
        Car.TripComputer tripComputer = car.new TripComputer();
        return tripComputer;
    }
}
