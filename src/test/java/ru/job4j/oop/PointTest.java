package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double result = a.distance(b);
        assertThat(result).isEqualTo(2.0, offset(0.001));
    }

    @Test
    public void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 2, 4);
        double result = a.distance3d(b);
        assertThat(result).isEqualTo(4.472, offset(0.001));
    }
}
