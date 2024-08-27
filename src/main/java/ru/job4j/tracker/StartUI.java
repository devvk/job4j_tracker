package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int index = input.askInt("Select: ");
            if (index < 0 || index >= actions.size()) {
                out.println("Wrong input, you can select: 0 - " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(index);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    /**
     * 1. Мы получаем от пользователя пункт меню.
     * 2. Этот параметр мы используем в качестве индекса в списке actions.
     * 3. Далее мы получаем из списка один из объектов UserAction (CreateAction, ReplaceAction...);
     * 4. У полученного объекта вызываем метод execute с передачей параметров input и tracker.
     */
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new Create(output),
                new FindAll(output),
                new Replace(output),
                new Delete(output),
                new FindById(output),
                new FindByName(output),
                new Exit(output)
        ));
        new StartUI(output).init(input, tracker, actions);
    }
}
