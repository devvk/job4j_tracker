package ru.job4j.stream;

/**
 * Record класс Subject описывает школьный предмет и аттестационный балл ученика.
 *
 * @param name  название предмета
 * @param score аттестационный балл ученика.
 */
public record Subject(String name, int score) {
}