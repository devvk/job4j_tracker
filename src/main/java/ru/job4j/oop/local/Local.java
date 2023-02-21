package ru.job4j.oop.local;

public class Local {
    private final String name = "Petr";

    /**
     * В данном примере локальный класс FullName вложен
     * в метод getFullName() класса Local.
     */
    public void getFullName() {
        String surname = "Arsentev";

        class FullName {
            public void printFullName() {
                System.out.println(name + " " + surname);
            }
        }

        FullName fullName = new FullName();
        fullName.printFullName();
    }

    public static void main(String[] args) {
        Local local = new Local();
        local.getFullName();
    }
}
