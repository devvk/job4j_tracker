package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private final Point first;
    private final Point second;
    private final Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * Полупериметр треугольника – это сумма длин всех его сторон, деленная на два.
     * Полупериметр обозначается буквой p.
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**
     * Существует ли треугольник.
     * Чтобы треугольник существовал, сумма двух сторон треугольника всегда должна
     * быть больше третей стороны.
     * a + b > c, b + c > a, a + c > b.
     */
    public boolean exist(double ab, double ac, double bc) {
        return (ab + ac > bc) && (ab + bc > ac) && (bc + ac > ab);
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}