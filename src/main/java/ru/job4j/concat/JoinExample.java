package ru.job4j.concat;

/**
 * String.join()
 * <p>
 * Когда нам нужно объединить 2 и более строки с каким-либо разделителем,
 * например, пробелом, то можно использовать метод join() класса String.
 */
public class JoinExample {
    public static void main(String[] args) {
        String str = String.join(" | ", "abc", "def", "ghi", "aed", "dgg");
        System.out.println(str);
    }
}
