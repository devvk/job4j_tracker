package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        if (array == null || array.length == 0) {
            return Collections.emptyList();
        }
        int totalElements = array.length * array[0].length;
        List<Integer> list = new ArrayList<>(totalElements);
        for (int[] row : array) {
            for (int element : row) {
                list.add(element);
            }
        }
        return list;
    }
}
