package ru.job4j.array;

public class SimpleStringEncoder {
    public static String encode(String input) {
        StringBuilder result = new StringBuilder();
        char currentSymbol = input.charAt(0);
        int counter = 1;

        for (int i = 1; i < input.length(); i++) {

            if (currentSymbol == input.charAt(i)) {
                counter++;
            } else {
                result.append(currentSymbol);
                if (counter > 1) {
                    result.append(counter);
                }
                currentSymbol = input.charAt(i);
                counter = 1;
            }
        }

        result.append(currentSymbol);
        if (counter > 1) {
            result.append(counter);
        }

        return result.toString();
    }
}
