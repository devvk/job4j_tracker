package ru.job4j.patterns.singleton;

import ru.job4j.tracker.MemTracker;

/**
 * Eager loading.
 * Загружает объект сразу после старта виртуальной машины.
 * Чтобы получить экземпляр класса, нужно напрямую обратиться к полю INSTANCE.
 */
public enum TrackerSingleEnum {
    INSTANCE;

    private final MemTracker tracker;

    TrackerSingleEnum() {
        this.tracker = new MemTracker();
    }

    public MemTracker getTracker() {
        return tracker;
    }

    public static void main(String[] args) {
        MemTracker tracker = TrackerSingleEnum.INSTANCE.getTracker();
    }
}
