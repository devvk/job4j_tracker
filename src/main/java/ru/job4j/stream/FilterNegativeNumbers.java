package ru.job4j.stream;

import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(100, 0, 10, -2, -44, 4, -1, 3);
        List<Integer> positive = numbers.stream().filter(
                number -> number > 0
        ).toList();
        positive.forEach(System.out::println);
    }
}
