package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HbmTrackerTest {

    @BeforeEach
    @AfterEach
    void wipeTable() {
        try (HbmTracker tracker = new HbmTracker()) {
            for (Item item : tracker.findAll()) {
                tracker.delete(item.getId());
            }
        }
    }

    @Test
    void whenAddNewItemThenTrackerHasSameItem() {
        try (HbmTracker tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    void whenReplaceItemThenTrackerHasUpdatedItem() {
        try (HbmTracker tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);

            Item newItem = new Item();
            newItem.setName("replacedItem");
            tracker.replace(item.getId(), newItem);

            Item replacedItem = tracker.findById(item.getId());
            assertThat(replacedItem.getName()).isEqualTo(newItem.getName());
        }
    }

    @Test
    void whenDeleteItemThenTrackerHasNoItem() {
        try (HbmTracker tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);

            tracker.delete(item.getId());
            Item result = tracker.findById(item.getId());
            assertThat(result).isNull();
        }
    }

    @Test
    void whenFindAllItemsThenTrackerHasAllItems() {
        try (HbmTracker tracker = new HbmTracker()) {
            Item item1 = new Item();
            item1.setName("test1");
            tracker.add(item1);
            Item item2 = new Item();
            item2.setName("test2");
            tracker.add(item2);
            Item item3 = new Item();
            item3.setName("test3");
            tracker.add(item3);

            List<Item> items = tracker.findAll();
            assertThat(items).isEqualTo(List.of(item1, item2, item3));
        }
    }

    @Test
    void whenFindItemsByNameThenTrackerHasItems() {
        try (HbmTracker tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);

            List<Item> foundItems = tracker.findByName(item.getName());
            assertThat(foundItems).isEqualTo(List.of(item));
        }
    }

    @Test
    void whenFindByNotExistingNameThenReturnNull() {
        try (HbmTracker tracker = new HbmTracker()) {
            List<Item> foundItems = tracker.findByName("not existing");
            assertThat(foundItems).isEqualTo(List.of());
        }
    }

    @Test
    void whenReplaceNotExistingItemThenReturnFalse() {
        try (HbmTracker tracker = new HbmTracker()) {
            Item result = tracker.findById(999);
            assertThat(result).isNull();
        }
    }
}
