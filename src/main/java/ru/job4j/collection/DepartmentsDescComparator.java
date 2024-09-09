package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split("/");
        String[] rightArray = right.split("/");

        int result = rightArray[0].compareTo(leftArray[0]);
        if (result != 0) {
            return result;
        }

        for (int i = 1; i < Math.min(leftArray.length, rightArray.length); i++) {
            result = leftArray[i].compareTo(rightArray[i]);
            if (result != 0) {
                return result;
            }
        }

        return Integer.compare(leftArray.length, rightArray.length);
    }
}
