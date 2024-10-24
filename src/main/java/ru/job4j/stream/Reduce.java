package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public record Person(String name, int age) {
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);

        Optional<Integer> sum = list.stream()
                .reduce(Integer::sum);
        System.out.println(sum.get());

        int sum2 = list.stream()
                .reduce(100, Integer::sum);
        System.out.println(sum2);

        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum3 = people.stream()
                .reduce(0,
                        (left, right) -> {
                            if (right.age() > 25) {
                                return left + right.age();
                            } else {
                                System.out.println("else: " + left);
                                return left;
                            }
                        },
                        Integer::sum
                );
        System.out.println(sum3);
    }
}
