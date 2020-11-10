package ru.job4j.singleton;

/**
 * enum. Eager loading.
 * Энергичная загрузка (Eager loading) - загружает объект сразу после старта виртуальной машины.
 * Чтобы получить экземпляр класса, нужно напрямую обратиться к полю INSTANCE.
 */
public enum TackerSingleEager {
    INSTANCE;

    public static void main(String[] args) {
        TackerSingleEager tracker = TackerSingleEager.INSTANCE;
        TackerSingleEager trackerAnother = TackerSingleEager.INSTANCE;
        System.out.println(tracker);
        System.out.println(trackerAnother);
    }
}
