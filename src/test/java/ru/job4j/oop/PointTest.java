package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

    @Test
    public void period() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        assertThat(a.distance(b), closeTo(2.0, 0.001));
        Point c = new Point(0, 0, 0);
        Point d = new Point(0, 2, 4);
        assertThat(c.distance3d(d), closeTo(4.472, 0.001));
    }
}