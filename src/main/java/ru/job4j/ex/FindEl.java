package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] array, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element '" + key + "' not found!");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"one", "two", "three", "four", "five"};
        String key = "six";
        try {
            System.out.println(indexOf(array, key));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
