package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingBy {

    public record Worker(String name, int age, int salary, String position) {
    }

    public static void main(String[] args) {

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

        System.out.println("Группировка списка рабочих по их должности (деление на списки):");
        groupingByPositionToList(workers);

        System.out.println("Группировка списка рабочих по их должности (деление на множества):");
        groupingByPositionToSet(workers);

        System.out.println("Подсчёт количества рабочих, занимаемых конкретную должность:");
        groupingByPositionAndCounting(workers);

        System.out.println("Группировка списка рабочих по их должности, только имена:");
        groupingByPositionAndGetNames(workers);

        System.out.println("Расчет средней зарплаты для данной должности:");
        groupingByPositionAndGetAverageSalary(workers);

        System.out.println("Группировка списка рабочих по их должности, "
                + "рабочие представлены только именами единой строкой");
        groupingByPositionAndGetNamesAsString(workers);

        System.out.println("Группировка списка рабочих по их должности и по возрасту:");
        groupingByPositionAndAge(workers);
    }

    /**
     * Группировка списка рабочих по их должности (деление на списки).
     *
     * @param workers список рабочих.
     */
    public static void groupingByPositionToList(List<Worker> workers) {
        Map<String, List<Worker>> map = workers.stream()
                .collect(Collectors.groupingBy(Worker::position));
        System.out.println(map);
    }

    /**
     * Группировка списка рабочих по их должности (деление на множества)
     *
     * @param workers список рабочих.
     */
    public static void groupingByPositionToSet(List<Worker> workers) {
        Map<String, Set<Worker>> map = workers.stream()
                .collect(Collectors.groupingBy(Worker::position, Collectors.toSet()));
        System.out.println(map);
    }

    /**
     * Подсчёт количества рабочих, занимаемых конкретную должность.
     *
     * @param workers список рабочих.
     */
    public static void groupingByPositionAndCounting(List<Worker> workers) {
        Map<String, Long> groups = workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::position,
                        Collectors.counting()
                ));
        System.out.println(groups);
    }

    /**
     * Группировка списка рабочих по их должности, при этом нас интересуют только имена.
     *
     * @param workers список рабочих.
     */
    public static void groupingByPositionAndGetNames(List<Worker> workers) {
        Map<String, Set<String>> map = workers.stream()
                .collect(Collectors.groupingBy(Worker::position,
                        Collectors.mapping(Worker::name, Collectors.toSet())
                ));
        System.out.println(map);
    }

    /**
     * Расчет средней зарплаты для данной должности.
     *
     * @param workers список рабочих.
     */
    public static void groupingByPositionAndGetAverageSalary(List<Worker> workers) {
        Map<String, Double> map = workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::position,
                        Collectors.averagingInt(Worker::salary)
                ));
        System.out.println(map);
    }

    /**
     * Группировка списка рабочих по их должности,
     * рабочие представлены только именами единой строкой.
     *
     * @param workers список рабочих.
     */
    public static void groupingByPositionAndGetNamesAsString(List<Worker> workers) {
        Map<String, String> map = workers.stream()
                .collect(Collectors.groupingBy(
                                Worker::position,
                                Collectors.mapping(
                                        Worker::name,
                                        Collectors.joining(", ", "{", "}")
                                )
                        )
                );
        System.out.println(map);

    }

    /**
     * Группировка списка рабочих по их должности и по возрасту.
     *
     * @param workers список рабочих.
     */
    public static void groupingByPositionAndAge(List<Worker> workers) {
        Map<String, Map<Integer, List<Worker>>> map = workers.stream()
                .collect(Collectors.groupingBy(Worker::position,
                        Collectors.groupingBy(Worker::age)));
        System.out.println(map);
    }

}
