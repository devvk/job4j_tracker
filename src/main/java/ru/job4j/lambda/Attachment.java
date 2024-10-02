package ru.job4j.lambda;

public record Attachment(String name, int size) {

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
