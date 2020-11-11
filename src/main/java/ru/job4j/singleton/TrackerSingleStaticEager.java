package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Тоже самое, что и с static field. Lazy loading.
 * Основное отличие, мы сразу создаем и инициализируем объект.
 * Энергичная загрузка (Eager loading) - загружает объект сразу после старта виртуальной машины.
 */
public class TrackerSingleStaticEager {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleStaticEager() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleStaticEager.getInstance();
    }
}
