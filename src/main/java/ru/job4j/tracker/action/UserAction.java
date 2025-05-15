package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.io.Input;

public interface UserAction {

    String name();

    /**
     * Метод возвращает boolean, чтобы создать действия выхода из программы.
     * Если действие вернуло false, то мы считаем, что пользователь вышел из системы.
     */
    boolean execute(Input input, Store tracker);
}
