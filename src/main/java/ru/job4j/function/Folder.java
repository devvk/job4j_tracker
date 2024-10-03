package ru.job4j.function;

public record Folder(String name, int size) {

    @Override
    public String toString() {
        return "Folder{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
