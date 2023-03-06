package ru.job4j.oop;

public class College {
    /**
     * Понижающего приведения в коде лучше избегать.
     */
    public static void main(String[] args) {
        /* up casting */
        Student student = new Freshman();

        /* up casting */
        Object object = new Freshman();

        System.out.println(student);
        System.out.println(object);
    }
}
