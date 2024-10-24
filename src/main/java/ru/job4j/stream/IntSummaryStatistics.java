package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class IntSummaryStatistics {
    public record Person(String name, int age) {
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );

        Optional<Person> min = people.stream()
                .min(Comparator.comparing(Person::age));

        Optional<Person> max = people.stream()
                .max(Comparator.comparing(Person::age));

        int sum = people.stream()
                .mapToInt(Person::age)
                .sum();

        OptionalDouble avg = people.stream()
                .mapToInt(Person::age)
                .average();

        long count = people.stream()
                .filter(p -> p.age > 30)
                .count();

        System.out.println(people);
        System.out.println("min: " + min.get());
        System.out.println("max: " + max.get());
        System.out.println("sum: " + sum);
        System.out.println("avg: " + avg.orElse(0));
        System.out.println("count: " + count);

        java.util.IntSummaryStatistics statisticsPerson = people.stream()
                .mapToInt(Person::age)
                .summaryStatistics();

        System.out.println("Statistics for Age:");
        System.out.println("Max: " + statisticsPerson.getMax());
        System.out.println("Min: " + statisticsPerson.getMin());
        System.out.println("Sum: " + statisticsPerson.getSum());
        System.out.println("Average: " + statisticsPerson.getAverage());
        System.out.println("Count: " + statisticsPerson.getCount());
    }
}
