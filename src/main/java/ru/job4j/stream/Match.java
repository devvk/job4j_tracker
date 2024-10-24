package ru.job4j.stream;

import java.util.List;

public class Match {
    public static void main(String[] args) {
        List<String> list = List.of("Один", "Два", "Три", "Четыре", "Пять");

        boolean result1 = list.stream()
                .noneMatch("Шесть"::equalsIgnoreCase);
        System.out.println(result1);

        boolean result2 = list.stream()
                .anyMatch(element -> element.endsWith("ь"));
        System.out.println(result2);

        boolean result3 = list.stream()
                .allMatch(element -> element.startsWith("Три"));
        System.out.println(result3);
    }
}
