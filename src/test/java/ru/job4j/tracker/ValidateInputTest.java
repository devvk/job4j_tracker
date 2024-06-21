package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"abc", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void checkOutput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"abc", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        input.askInt("Enter menu: ");
        assertThat(out.toString()).isEqualTo("Please enter valid data."
                + System.lineSeparator());
    }
}
