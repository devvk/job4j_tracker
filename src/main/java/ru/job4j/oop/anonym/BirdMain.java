package ru.job4j.oop.anonym;

public class BirdMain {
    /**
     * Анонимный класс - это локальный класс без имени.
     * Анонимным классом следует пользоваться, если нужен
     * локальный класс для одноразового использования.
     */
    public static void main(String[] args) {
        Bird parrot = new Bird() {
            @Override
            public void fly() {
                System.out.println("Testing anonymous class Bird.");
                System.out.println("Попугай пролетает над лужайкой.");
            }
        };

        parrot.fly();
    }
}
