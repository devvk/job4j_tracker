package ru.job4j.nested;

public class Bicycle {
    private final String model;
    private final int weight;

    private int size = 45;

    public Bicycle(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }

    public void start() {
        System.out.println("Поехали!");
    }

    public class HandleBar {
        public void right() {
            System.out.println("Руль вправо!");
        }

        public void left() {
            System.out.println("Руль влево!");
        }
    }

    public class Seat {
        public void up() {
            System.out.println("Сидение поднято выше!");
            System.out.println(Integer.toString(Bicycle.this.size));
        }

        public void down() {
            System.out.println("Сидение опущено ниже!");
        }
    }

    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle("MBX", 19);
        Bicycle.HandleBar handleBar = bicycle.new HandleBar();
        Bicycle.Seat seat = bicycle.new Seat();

        bicycle.start();
        seat.up();
        handleBar.left();
        handleBar.right();
        seat.down();
    }
}
