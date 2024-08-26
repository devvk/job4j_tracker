package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        Objects.requireNonNull(list, "list is null");
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int i : array) {
                result.add(i);
            }
        }
        return result;
    }
}
