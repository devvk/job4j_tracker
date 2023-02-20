package ru.job4j.oop.vehicle;

public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck();
        truck.setBrand("Mercedes");
        truck.setModel("T100");
        truck.setType("BigTruck");
        truck.setMaxSpeed(120);
        truck.setPassengers(3);
        System.out.println("Brand: " + truck.getBrand()
                + ", model: " + truck.getModel() + ", type: "
                + truck.getType() + ", maxSpeed: "
                + truck.getMaxSpeed() + ", passengers: "
                + truck.getPassengers());
        truck.accelerate();
        truck.steer();
        truck.brake();
    }
}
