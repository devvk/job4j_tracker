package ru.job4j.tracker;

/**
 * Класс ValidateInput получает данные из системы ввода до тех пор,
 * пока не введут правильные символы.
 */
public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data.");
            }
        } while (invalid);
        return value;
    }
}
