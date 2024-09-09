package ru.job4j.collection;

import java.util.*;

public class Departments {

    /**
     * Заполняет и сортирует коды подразделений.
     *
     * @param departments массив строк кодов подразделений
     * @return отсортированные подразделения
     */
    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String department : departments) {
            StringBuilder start = new StringBuilder();
            for (String element : department.split("/")) {
                temp.add(start + element);
                start.append(element).append("/");
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}
