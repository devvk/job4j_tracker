package ru.job4j.stream;

import java.util.List;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> product.standard() - product.actual() >= 0)
                .filter(product -> product.standard() - product.actual() <= 3)
                .map(product -> new Label(product.name(), product.price() * 0.5f).toString())
                .toList();
    }
}
