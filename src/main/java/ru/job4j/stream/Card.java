package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private final Suit suit;
    private final Value value;

    /**
     * Генерирует колоду карт.
     * Чтобы получить поток из перечисления, нужно использовать метод
     * Stream.of(Suit.values())
     */
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values()).map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + suit + " " + value
                + "}";
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }
}