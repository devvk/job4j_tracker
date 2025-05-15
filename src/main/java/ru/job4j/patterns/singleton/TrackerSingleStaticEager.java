package ru.job4j.patterns.singleton;

import ru.job4j.tracker.MemTracker;

/**
 * Тоже самое, что и с static field. Lazy loading.
 * Основное отличие, мы сразу создаем и инициализируем объект.
 * Энергичная загрузка (Eager loading) - загружает объект сразу после старта виртуальной машины.
 */
public class TrackerSingleStaticEager {
    private static final MemTracker INSTANCE = new MemTracker();

    private TrackerSingleStaticEager() {
    }

    public static MemTracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        MemTracker tracker = TrackerSingleStaticEager.getInstance();
    }
}
