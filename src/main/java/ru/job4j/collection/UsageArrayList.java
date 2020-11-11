package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Oleg");
        list.set(0, "Petr");
        list.add("Anton");
        list.remove(1);
        list.add("Ivan");
        list.add("Stepan");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
