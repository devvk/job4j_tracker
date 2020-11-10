package ru.job4j.singleton;

/**
 * Объект класса находиться в поле внутреннего класса.
 * Ленивая загрузка (Lazy loading) происходит, когда мы явно обращаемся к объекту.
 * Происходит его загрузка.
 */
public class TrackerSingleStaticLazy {
    private TrackerSingleStaticLazy() {
    }

    public static TrackerSingleStaticLazy getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleStaticLazy INSTANCE = new TrackerSingleStaticLazy();
    }

    public static void main(String[] args) {
        TrackerSingleStaticLazy tracker = TrackerSingleStaticLazy.getInstance();
        System.out.println(tracker);
    }
}
