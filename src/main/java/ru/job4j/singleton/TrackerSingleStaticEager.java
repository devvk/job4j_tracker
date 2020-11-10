package ru.job4j.singleton;

/**
 * Тоже самое, что и с static field. Lazy loading.
 * Основное отличие, мы сразу создаем и инициализируем объект.
 * Энергичная загрузка (Eager loading) - загружает объект сразу после старта виртуальной машины.
 */
public class TrackerSingleStaticEager {
    private static final TrackerSingleStaticEager INSTANCE = new TrackerSingleStaticEager();

    private TrackerSingleStaticEager() {
    }

    public static TrackerSingleStaticEager getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        TrackerSingleStaticEager tracker = TrackerSingleStaticEager.getInstance();
        System.out.println(tracker);
    }
}
