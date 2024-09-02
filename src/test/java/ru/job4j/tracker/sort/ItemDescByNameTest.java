package ru.job4j.tracker.sort;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    public void whenItemSortedDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Sven"),
                new Item("Zoe"),
                new Item("Bob"),
                new Item("Peter"),
                new Item("Alex")
        );
        List<Item> expected = Arrays.asList(
                new Item("Zoe"),
                new Item("Sven"),
                new Item("Peter"),
                new Item("Bob"),
                new Item("Alex")
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }

}