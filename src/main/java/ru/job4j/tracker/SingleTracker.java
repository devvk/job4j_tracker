package ru.job4j.tracker;

public final class SingleTracker {

    private final Tracker tracker = new Tracker();

    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public static void main(String[] args) {
        String name = "new item";
        Item item = new Item(name);
        SingleTracker singleTracker = SingleTracker.getInstance();
        singleTracker.add(item);
        Item[] items = singleTracker.findByName(name);
        System.out.println("findByName: " + items.length);
        items = singleTracker.findAll();
        System.out.println("findAll: " + items.length);
        Item found = singleTracker.findById(1);
        singleTracker.replace(1, found);
        System.out.println("delete: " + singleTracker.delete(1));
    }
}
