package ru.job4j.patterns.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Eager loading.
 * Загружает объект сразу после старта виртуальной машины.
 * Чтобы получить экземпляр класса, нужно напрямую обратиться к полю INSTANCE.
 */
public enum TrackerSingleEnum {
    INSTANCE;

    private final Tracker tracker;

    TrackerSingleEnum() {
        this.tracker = new Tracker();
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleEnum.INSTANCE.getTracker();
    }
}
