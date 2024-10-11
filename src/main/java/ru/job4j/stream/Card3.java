package ru.job4j.stream;

import java.util.stream.Stream;

public class Card3 {
    private final Suit suit;
    private final Value value;
    private final Color color;

    /**
     * Генерирует 3 колоды карт.
     * Получить поток из перечисления: Stream.of(Suit.values())
     */
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .flatMap(value -> Stream.of(Color.values())
                                .map(color -> new Card3(suit, value, color))))
                .forEach(System.out::println);
    }

    public Card3(Suit suit, Value value, Color color) {
        this.suit = suit;
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Card{"
                + suit + " " + value + " " + color + '}'
                + "}";
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public enum Color {
        RED, BLACK, WHITE
    }
}