package ru.job4j.poly;

public class MemStore implements Store {
    private final String[] mem = new String[100];
    private int size = 0;

    @Override
    public void save(String date) {
        mem[size++] = date;
    }

    @Override
    public String read() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(mem[i]);
        }
        return sb.toString();
    }
}
