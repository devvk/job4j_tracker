package ru.job4j.stream;

import java.time.LocalDate;

public class Car {

    private String brand;
    private String model;
    private LocalDate created;
    private double volume;
    private String color;

    @Override
    public String toString() {
        return "Car{"
                + "brand=" + brand
                + ", model=" + model
                + ", created=" + created
                + ", volume=" + volume
                + ", color=" + color
                + "}";
    }

    public static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        public Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        public Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        public Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        public Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.created = created;
            car.volume = volume;
            car.color = color;
            return car;
        }
    }

    public static void main(String[] args) {
        Car c1 = new Builder()
                .buildBrand("Audi")
                .buildModel("Q5")
                .buildCreated(LocalDate.of(2024, 10, 24))
                .buildVolume(3.0)
                .buildColor("Black")
                .build();

        Car c2 = new Builder()
                .buildBrand("Mercedes")
                .buildModel("GLS")
                .build();

        System.out.println(c1);
        System.out.println(c2);
    }
}
