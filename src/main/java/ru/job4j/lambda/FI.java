package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        String[] strings = {"Donald Duck", "G", "A", "Ba", "Canada", "Faa"};

        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
        Arrays.sort(strings, comparatorText);
        System.out.println(Arrays.toString(strings));

        Comparator<String> comparatorDescSize =
                (left, right) -> Integer.compare(right.length(), left.length());
        Arrays.sort(strings, comparatorDescSize);
        System.out.println(Arrays.toString(strings));
    }
}
