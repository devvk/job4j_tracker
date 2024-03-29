package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println(new Fact().calc(10));
        System.out.println(new Fact().calc(-5));
    }

    public int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("N could not be less then 0.");
        }
        for (int i = 1; i <= n; i++) {
            rsl *= i;
        }
        return rsl;
    }
}
