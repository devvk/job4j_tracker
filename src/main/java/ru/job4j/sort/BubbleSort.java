package ru.job4j.sort;

import java.util.Arrays;

/**
 * Сортировка пузырьком
 * <p>
 * При каждом проходе алгоритма по внутреннему циклу очередной наибольший элемент
 * массива ставится на своё место в конце массива рядом с предыдущим «наибольшим
 * элементом», а наименьший элемент перемещается на одну позицию к началу массива
 * («всплывает» до нужной позиции, как пузырёк в воде — отсюда и название алгоритма).
 */
public class BubbleSort {
    public static void sort(int[] array) {
        for (int border = array.length - 1; border >= 0; border--) {
            for (int i = 0; i < border; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{34, 55, 2, 4, 1, 6, 12, 16, 10};
        System.out.println("до: \t" + Arrays.toString(array));
        BubbleSort.sort(array);
        System.out.println("после: \t" + Arrays.toString(array));
    }
}
