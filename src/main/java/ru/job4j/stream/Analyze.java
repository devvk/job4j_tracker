package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    /**
     * Вычисляет общий средний балл.
     *
     * @param stream поток учеников.
     * @return общий средний балл.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0);
    }

    /**
     * Вычисляет средний балл по каждому ученику.
     *
     * @param stream поток учеников.
     * @return список из объекта Tuple (имя ученика и средний балл).
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(
                        pupil.name(),
                        pupil.subjects().stream()
                                .mapToInt(Subject::score)
                                .average()
                                .orElse(0)
                ))
                .toList();
    }

    /**
     * Вычисляет средний балл по каждому предмету.
     *
     * @param stream поток учеников.
     * @return список из объектов Tuple (название предмета и средний балл).
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .collect(
                        Collectors.groupingBy(
                                Subject::name,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::score)
                        )
                )
                .entrySet()
                .stream()
                .map((entry) -> new Tuple(
                        entry.getKey(),
                        entry.getValue()
                )).toList();
    }

    /**
     * Вычисляет лучшего ученика.
     * Лучшим считается ученик с наибольшим суммарным баллом по всем предметам.
     *
     * @param stream поток учеников.
     * @return объект Tuple (имя ученика и суммарный балл).
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(
                        pupil.name(),
                        pupil.subjects().stream()
                                .mapToInt(Subject::score)
                                .sum()
                ))
                .max(Comparator.comparing(Tuple::score)).orElse(null);
    }

    /**
     * Вычисляет предмет с наибольшим баллом для всех студентов.
     *
     * @param stream поток учеников.
     * @return объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету).
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .collect(
                        Collectors.groupingBy(
                                Subject::name,
                                LinkedHashMap::new,
                                Collectors.summingDouble(Subject::score)
                        )
                )
                .entrySet()
                .stream()
                .map((entry) -> new Tuple(
                        entry.getKey(),
                        entry.getValue()
                ))
                .max(Comparator.comparing(Tuple::score)).orElse(null);
    }
}
