package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item i1 = new Item(1, "Test name");
        System.out.println(i1);
        Item i2 = new Item(2);
        System.out.println(i2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = i1.getCreated().format(formatter);
        System.out.println(currentDateTimeFormat);
    }
}
