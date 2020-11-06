package ru.job4j.tracker;

public class FindAllAction implements UserAction {

    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "FindAll";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find all items ====");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            out.println(item);
        }
        return true;
    }
}
