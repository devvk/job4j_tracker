package ru.job4j.poly;

public class FileStore implements Store {
    private final String path;

    public FileStore(String path) {
        this.path = path;
    }

    @Override
    public void save(String data) {
        System.out.println(path);
        System.out.println(data);
    }

    @Override
    public String read() {
        return null;
    }
}
