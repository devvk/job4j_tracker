package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class Replace implements UserAction {

    private final Output out;

    public Replace(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(name))) {
            out.println("Edit success.");
        } else {
            out.println("Edit failure!");
        }
        return true;
    }
}
