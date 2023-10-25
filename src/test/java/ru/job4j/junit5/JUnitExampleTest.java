package ru.job4j.junit5;


import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * JUnit 5 User Guide
 * <a href="https://junit.org/junit5/docs/current/user-guide/">JUnit 5 User Guide</a>
 */
//@Disabled("Need to fix impl")
class JUnitExampleTest {
    @Test
    @DisplayName("When 5 multi 5 should be 25")
    void when5and5then25() {
        JUnitExample example = new JUnitExample();
        int result = example.multiply(5, 5);
        assertThat(result).isEqualTo(25);
    }

    @RepeatedTest(2)
    void when5and5then25withRepeat() {
        JUnitExample example = new JUnitExample();
        int result = example.multiply(5, 5);
        assertThat(result).isEqualTo(25);
    }

    @Disabled
    @Test
    void when5and5then25withDisabled() {
        JUnitExample example = new JUnitExample();
        int result = example.multiply(5, 5);
        assertThat(result).isEqualTo(25);
    }

    /**
     * @throws InterruptedException Interrupted
     * @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
     */
    @Timeout(3)
    @Test
    void when5and5then25Timeout3sec() throws InterruptedException {
        Thread.sleep(1000);
        JUnitExample example = new JUnitExample();
        int result = example.multiply(5, 5);
        assertThat(result).isEqualTo(25);
    }

}
