package ru.job4j.concat;

/**
 * String.concat()
 * <p>
 * Удобно пользоваться, если у нас уже есть готовые строки, которые мы просто хотим объединить
 * и получить результат.
 * Метод concat() класса String возвращает объект String.
 * Метод concat() можно объединять в цепочку, в результате работы которой будет возвращена новая
 * строка без накладных расходов в виде создания промежуточных строк.
 */
public class ConcatExample {
    public static void main(String[] args) {
        String str = "abc".concat("abd").concat("abe").concat("abv");
        System.out.println(str);
    }
}
