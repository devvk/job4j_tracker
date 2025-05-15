package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class Delete implements UserAction {

    private final Output out;

    public Delete(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        boolean result = tracker.findById(id) != null;
        if (result) {
            tracker.delete(id);
            out.println("Delete success.");
        } else {
            out.println("Item not found! Delete failure!");
        }
        return result;
    }
}
