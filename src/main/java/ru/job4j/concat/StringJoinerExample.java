package ru.job4j.concat;

import java.util.StringJoiner;

/**
 * StringJoiner базируется на StringBuilder и имеет удобную возможность соединять строки через
 * разделитель,а также добавлять префикс и/или суффикс к результирующей строке.
 */
public class StringJoinerExample {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        stringJoiner.add("asd").add("jkl").add("asb").add("jfs");
        System.out.println(stringJoiner);
    }
}
