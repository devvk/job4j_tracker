package ru.job4j.patterns.singleton;

import ru.job4j.tracker.MemTracker;

/**
 * Объект класса находиться в поле внутреннего класса.
 * Ленивая загрузка (Lazy loading) происходит, когда мы явно обращаемся к объекту.
 * Происходит его загрузка.
 */
public class TrackerSingleStaticLazy {
    private TrackerSingleStaticLazy() {
    }

    public static MemTracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final MemTracker INSTANCE = new MemTracker();
    }

    public static void main(String[] args) {
        MemTracker tracker = TrackerSingleStaticLazy.getInstance();
    }
}
