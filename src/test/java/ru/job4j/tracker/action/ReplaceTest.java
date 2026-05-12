package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubOutput;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReplaceTest {

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        UserAction replaceAction = new Replace(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(String.valueOf(item.getId()), "New Item Name");

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Edit item ===" + ln
                        + "Edit success." + ln
        );
    }
}
