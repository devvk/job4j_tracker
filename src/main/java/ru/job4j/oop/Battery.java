package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public String about() {
        return "My charge: " + load + "%";
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery second = new Battery(20);
        System.out.println("first: " + first.load + ", \t second: " + second.load);
        first.exchange(second);
        System.out.println("first: " + first.load + ", \t second: " + second.load);
    }
}
