package ru.job4j.polymorph;

/**
 * Интерфейс - транспортное средство.
 * <p>
 * С помощью этих методов мы описали поведение: ускориться, тормозить, рулить,
 * переключить передачу, но не задали абсолютно никакой реализации.
 */
public interface Vehicle extends Fuel {

    double FUEL_PRICE = 2.22;

    void accelerate();

    void brake();

    void steer();

    void changeGear();

    default void testMethod() {
        System.out.println("default testMethod() в interface Vehicle");
    }

    static void getDragCoefficient() {
        System.out.println("Формула коэффициента аэродинамического сопротивления автомобиля");
    }

    default void chargeBattery() {
        System.out.println("Аккумулятор под капотом. Зарядить.");
    }
}
