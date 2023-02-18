package ru.job4j.oop;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {

    /**
     * Координата точки по оси x.
     */
    private final int x;

    /**
     * Координата точки по оси y.
     */
    private final int y;

    /**
     * Координата точки по оси z (для трехмерных объектов).
     */
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Конструктор.
     *
     * @param x координата
     * @param y координата
     * @param z координата
     */
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Метод рассчитывает расстояние между двумя точками.
     *
     * @param other вторая точка
     * @return расстояние
     */
    public double distance(Point other) {
        return sqrt(pow(this.x - other.x, 2) + pow(this.y - other.y, 2));
    }

    /**
     * Метод рассчитывает расстояние между двумя точками в трёхмерном пространстве.
     *
     * @param other вторая точка
     * @return расстояние
     */
    public double distance3d(Point other) {
        return sqrt(pow(this.x - other.x, 2) + pow(this.y - other.y, 2) + pow(this.z - other.z, 2));
    }
}
