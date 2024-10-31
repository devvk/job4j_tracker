package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingBy {

    public static void main(String[] args) {

        record Worker(String name, int age, int salary, String position) {
        }

        List<Worker> workers = List.of(
                new Worker("name1", 21, 2100, "Junior"),
                new Worker("name2", 22, 2200, "Junior"),
                new Worker("name3", 23, 2300, "Junior"),
                new Worker("name4", 31, 3100, "Middle"),
                new Worker("name5", 32, 3200, "Middle"),
                new Worker("name6", 33, 3300, "Middle"),
                new Worker("name7", 41, 4100, "Senior"),
                new Worker("name8", 42, 4200, "Senior"),
                new Worker("name9", 43, 4300, "Senior")
        );

        Map<String, Long> groups = workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::position,
                        Collectors.counting()
                ));
        System.out.println(groups);

        Map<String, Set<Worker>> map2 = workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::position,
                        Collectors.toSet()
                ));
        System.out.println(map2);

        Map<String, Set<String>> map3 = workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::position,
                        Collectors.mapping(Worker::name, Collectors.toSet())
                ));
        System.out.println(map3);

        Map<String, Double> map4 = workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::position,
                        Collectors.averagingInt(Worker::salary)
                ));
        System.out.println(map4);

        Map<String, String> map5 = workers.stream()
                .collect(Collectors.groupingBy(
                                Worker::position,
                                Collectors.mapping(
                                        Worker::name,
                                        Collectors.joining(", ", "{", "}")
                                )
                        )
                );
        System.out.println(map5);

        Map<String, Map<Integer, List<Worker>>> collect = workers.stream()
                .collect(Collectors.groupingBy(Worker::position,
                        Collectors.groupingBy(Worker::age)));
        System.out.println(collect);
    }
}
