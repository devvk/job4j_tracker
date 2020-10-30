package ru.job4j.inheritance;

/**
 * Пример кмпозиции
 */
public final class LiquidationProduct {

    private final Product product;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
    }

    public int discount() {
        return 90;
    }
}

