package ru.job4j.poly;

public class Service {
    private final Store store;

    Service(Store store) {
        this.store = store;
    }

    public void add() {
        store.save("data");
    }

    public String get() {
        return store.read();
    }

    public static void main(String[] args) {
        FileStore fileStore = new FileStore("some path");
        Service s1 = new Service(fileStore);
        s1.add();
        System.out.println(s1.get());

        MemStore memStore = new MemStore();
        Service s2 = new Service(memStore);
        s2.add();
        s2.get();
    }
}
