package ru.job4j.stream;

import java.util.List;

/**
 * Record класс Pupil описывает ученика.
 *
 * @param name     имя ученика.
 * @param subjects предметы ученика.
 */
public record Pupil(String name, List<Subject> subjects) {
}