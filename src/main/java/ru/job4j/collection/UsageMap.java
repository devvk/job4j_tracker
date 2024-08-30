package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("ivanov@mail.ru", "Иванов Иван Иванович");
        map.put("petrov@mail.ru", "Петров Пётр Петрович");
        map.put("petrov@mail.ru", "Петров Пётр Петрович");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
