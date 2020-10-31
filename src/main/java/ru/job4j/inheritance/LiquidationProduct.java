package ru.job4j.inheritance;

/**
 * Пример композиции
 */
public final class LiquidationProduct {

    private final Product product;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
    }

    public int discount() {
        return 90;
    }

    public Product getProduct() {
        return product;
    }
}

