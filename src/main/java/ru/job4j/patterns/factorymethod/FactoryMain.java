package ru.job4j.patterns.factorymethod;

public class FactoryMain {
    public static void main(String[] args) {
        Creator[] creators = {new ConcreteCreatorA(), new ConcreteCreatorB()};
        for (Creator creator : creators) {
            Product product = creator.factoryMethod();
            System.out.printf("Created [%s]\n", product.getClass().getSimpleName());
        }
    }
}
