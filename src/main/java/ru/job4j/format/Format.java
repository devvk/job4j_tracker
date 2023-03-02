package ru.job4j.format;

import java.util.Calendar;

public class Format {

    public static void getGreeting(String name) {
        System.out.printf("Hello %s.%n", name);
    }

    public static void main(String[] args) {
        String name = "String.format()";
        String text = String.format("Тестирование метода: %s", name);
        System.out.println(text);
        getGreeting("student");
        System.out.println(String.format("Jo%c4j", 'b'));
        System.out.format("Строка1%nСтрока2%n");
        Calendar calendar = Calendar.getInstance();
        System.out.println(String.format("Date: %tF, Time: %tT", calendar, calendar));
        System.out.println(String.format("Число с плавающей точкой: %.2f", 0.123456789));
    }
}
