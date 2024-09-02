package ru.job4j.tracker.sort;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    public void whenItemSortedAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Sven"),
                new Item("Zoe"),
                new Item("Bob"),
                new Item("Peter"),
                new Item("Alex")
        );
        List<Item> expected = Arrays.asList(
                new Item("Alex"),
                new Item("Bob"),
                new Item("Peter"),
                new Item("Sven"),
                new Item("Zoe")
        );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }
}