package ru.job4j.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] array) {
        System.out.println("до: \t" + Arrays.toString(array));
        for (int barier = array.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
        System.out.println("после: \t" + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = new int[]{34, 55, 2, 4, 1, 6, 12, 16, 10};
        BubbleSort.sort(array);
    }
}
