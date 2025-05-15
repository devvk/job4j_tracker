package ru.job4j.patterns.singleton;

import ru.job4j.tracker.MemTracker;

/**
 * Ленивая загрузка (Lazy loading) происходит, когда мы явно обращаемся к объекту.
 * Происходит его загрузка.
 * <p>
 * Для того чтобы закрыть возможность создавать экземпляр класса,
 * нам нужно явно создать конструктор по умолчанию и присвоить ему модификатор private.
 */
public class TrackerSingleLazy {

    private static MemTracker instance;

    private TrackerSingleLazy() {
    }

    /**
     * Метод проверяет статическое поле instance,
     * если поле не загружено, оно инициализируется новосозданным объектом.
     */
    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }

    public static void main(String[] args) {
        MemTracker tracker = TrackerSingleLazy.getInstance();
    }
}
