package ru.job4j.checkstyle;

public class Broken {
    private final int size = 10;

    private final String name;

    private final String surname;

    public static final String NEW_VALUE = "test";

    public Broken(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void echo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("size: " + size);
        System.out.println(NEW_VALUE);
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int a, int b, int c, int d, int e, int f, int g) {
        System.out.println(size + a + b + c + d + e + f + g);
    }

    public static void main(String[] args) {
        Broken broken = new Broken("Alex", "Johnson");
        broken.echo();
        for (int i = 1; i < 5; i++) {
            broken.method(i + 1, i + 2, i + 3, i + 4, i + 5, i + 6, i + 7);
        }
        broken.media(broken);
    }
}
