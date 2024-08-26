package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null.");
        }
        if (cells <= 0) {
            throw new IllegalArgumentException("Cells must be greater than 0.");
        }
        int size = list.size();
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        for (int i = 0; i < size; i++) {
            int row = i / cells;
            int cell = i % cells;
            array[row][cell] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] result = toArray(list, 3);
        for (int[] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
