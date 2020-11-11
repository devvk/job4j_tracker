package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Объект класса находиться в поле внутреннего класса.
 * Ленивая загрузка (Lazy loading) происходит, когда мы явно обращаемся к объекту.
 * Происходит его загрузка.
 */
public class TrackerSingleStaticLazy {
    private TrackerSingleStaticLazy() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleStaticLazy.getInstance();
    }
}
