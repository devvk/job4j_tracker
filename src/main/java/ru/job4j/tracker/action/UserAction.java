package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public interface UserAction {

    String name();

    /**
     * Метод возвращает boolean, чтобы создать действия выхода из программы.
     * Если действие вернуло false, то мы считаем, что пользователь вышел из системы.
     */
    boolean execute(Input input, Tracker tracker);
}
