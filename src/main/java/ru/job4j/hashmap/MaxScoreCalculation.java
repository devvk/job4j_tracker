package ru.job4j.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MaxScoreCalculation {
    private final static int MAX_ELEMENTS = 10_000_000;

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("Количество объектов Label в ArrayList: " + MAX_ELEMENTS);
        generateLabelsAndSort(rand);
        generateLabelsAndGetMaxWithoutSort(rand);
    }

    /**
     * Поиск максимума с сортировкой. Сложность O(N log N).
     *
     * @param rand Number generator.
     */
    private static void generateLabelsAndSort(Random rand) {
        List<Label> list = new ArrayList<>();
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            list.add(new Label(Integer.toString(i), rand.nextDouble(MAX_ELEMENTS)));
        }
        long start = System.currentTimeMillis();
        Collections.sort(list);
        double maxScore = list.get(list.size() - 1).score();
        long end = System.currentTimeMillis();
        System.out.printf("С сортировкой: maxScore = %.2f | Время выполнения: %s ms.\n",
                maxScore, (end - start));
    }

    /**
     * Поиск максимума без сортировки. Сложность O(N).
     *
     * @param rand Number generator.
     */
    private static void generateLabelsAndGetMaxWithoutSort(Random rand) {
        List<Label> list = new ArrayList<>();
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            list.add(new Label(Integer.toString(i), rand.nextDouble(MAX_ELEMENTS)));
        }
        long start = System.currentTimeMillis();
        double maxScore = Double.MIN_VALUE;
        for (Label label : list) {
            if (label.score() > maxScore) {
                maxScore = label.score();
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("Без сортировки: maxScore = %.2f | Время выполнения: %s ms.\n",
                maxScore, (end - start));
    }
}
