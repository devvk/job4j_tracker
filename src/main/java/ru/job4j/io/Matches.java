package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int count = 11;
        while (count > 0) {
            System.out.print("Введите число от 1 до 3 для игрока №1: ");
            Scanner input1 = new Scanner(System.in);
            int score1 = Integer.valueOf(input1.nextLine());
            if (score1 >= 1 && score1 <= 3) {
                count -= score1;
            }
            System.out.println("Количество спичек на столе: " + count);
            System.out.print("Введите число от 1 до 3 для игрока №2: ");
            Scanner input2 = new Scanner(System.in);
            int score2 = Integer.valueOf(input2.nextLine());
            count -= score2;
            System.out.println("Количество спичек на столе: " + count);
        }
    }
}
