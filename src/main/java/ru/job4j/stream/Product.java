package ru.job4j.stream;

import java.util.Objects;

public record Product(String name, float price, int standard, int actual) {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0
                && standard == product.standard
                && actual == product.actual
                && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, standard, actual);
    }
}
