package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

import java.util.List;

public class FindAll implements UserAction {

    private final Output out;

    public FindAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find all items ===");
        List<Item> items = tracker.findAll();
        for (Item item : items) {
            out.println(item);
        }
        return true;
    }
}
