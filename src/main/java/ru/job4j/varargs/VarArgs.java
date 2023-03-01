package ru.job4j.varargs;

/**
 * Параметр strings в методе text() неявно будет приведён к массиву при передаче аргументов.
 * Параметр varargs всегда должен быть объявлен последним среди всех параметров метода,
 * а также он должен быть единственным. Нельзя объявить 2 параметра varargs в сигнатуре
 * одного и того же метода.
 * Если нужно принимать параметры разных типов, то типом параметра varargs нужно сделать Object.
 */
public class VarArgs {
    public static String text(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        System.out.println("Количество параметров: " + strings.length);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(text());
        System.out.println(text("one"));
        System.out.println(text("one", "two"));
        System.out.println(text("one", "two", "three"));
    }
}
