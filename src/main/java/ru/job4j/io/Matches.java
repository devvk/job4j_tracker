package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int count = 11;
        boolean player = true;
        Scanner input = new Scanner(System.in);
        while (count > 0) {
            String name = player ? "player №1" : "player №2";
            System.out.print("Введите число от 1 до 3 для " + name + ": ");
            int score = Integer.parseInt(input.nextLine());
            if (score >= 1 && score <= 3) {
                count -= score;
                player = !player;
            }
            System.out.println("Количество спичек на столе: " + count);
            if (count <= 0) {
                System.out.println("Игра окончена! Победитель: " + name);
            }
        }
    }
}
