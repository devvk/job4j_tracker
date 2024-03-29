package ru.job4j.io;

import java.util.Scanner;

/**
 * Игра 11.
 * На столе лежат 11 спичек.
 * Два игрока по очереди берут от 1 до 3 спичек.
 * Выигрывает тот, кто забрал последние спички.
 */
public class Matches {
    public static void main(String[] args) {
        int count = 11;
        boolean player = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        while (count > 0) {
            String name = player ? "player №1" : "player №2";
            System.out.print("Введите число от 1 до 3 для " + name + ": ");
            int score = Integer.parseInt(input.nextLine());
            if (score >= 1 && score <= 3) {
                count -= score;
                player = !player;
            }
            System.out.println("Количество спичек на столе: " + count);
        }
        String name = !player ? "player №1" : "player №2";
        System.out.println("Игра окончена! Победитель: " + name);
    }
}
