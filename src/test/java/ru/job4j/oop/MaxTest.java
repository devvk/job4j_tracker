package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxTest {
    @Test
    public void whenMax2To1Then2() {
        int result = Max.max(2, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void whenMax2To2Then2() {
        int result = Max.max(2, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void whenMax3To1And2Then3() {
        int result = Max.max(2, 1, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void whenMax6To1And3Then6() {
        int result = Max.max(6, 1, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void whenMax6To6And6Then6() {
        int result = Max.max(6, 6, 6);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void whenMax13To1And2And3Then13() {
        int result = Max.max(1, 2, 3, 13);
        assertThat(result).isEqualTo(13);
    }

    @Test
    public void whenMax5To4And1And3Then5() {
        int result = Max.max(5, 4, 1, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void whenMax5To5And5And5Then5() {
        int result = Max.max(5, 5, 5, 5);
        assertThat(result).isEqualTo(5);
    }
}
