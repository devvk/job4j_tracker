package ru.job4j.tracker;

public class FindAllAction implements UserAction {

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find all items ====");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item);
        }
        return true;
    }
}
