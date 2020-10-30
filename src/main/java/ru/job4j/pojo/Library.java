package ru.job4j.pojo;

public class Library {

    @SuppressWarnings("checkstyle:LineLength")
    public static void main(String[] args) {
        Book b1 = new Book("Шилдт Г. - Java 8. Полное руководство - 2015", 1337);
        Book b2 = new Book("Java. Библиотека профессионала, том 1. Основы", 866);
        Book b3 = new Book("Head First Java. 2nd Edition.", 677);
        Book b4 = new Book("Clean code", 756);
        Book[] books = new Book[4];
        books[0] = b1;
        books[1] = b2;
        books[2] = b3;
        books[3] = b4;
        for (Book book : books) {
            System.out.println("Название: \""
                    + book.getName() + "\" \t["
                    + book.getPages()
                    + " стр.]");
        }
        books[0] = b4;
        books[3] = b1;
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println("Название: \""
                        + book.getName() + "\" \t["
                        + book.getPages()
                        + " стр.]");
            }
        }
    }
}
