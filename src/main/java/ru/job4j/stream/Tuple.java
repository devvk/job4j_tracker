package ru.job4j.stream;

/**
 * Record класс Tuple содержит результаты: имя и баллы.
 * Этот класс используется как для учеников, так и для предметов.
 *
 * @param name  имя ученика или название предмета.
 * @param score оценка.
 */
public record Tuple(String name, double score) {
}