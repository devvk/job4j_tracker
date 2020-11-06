package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            out.println("Delete success.");
        } else {
            out.println("Delete failure!");
        }
        return true;
    }
}
