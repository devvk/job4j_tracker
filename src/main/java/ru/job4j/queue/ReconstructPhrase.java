package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < evenElements.size(); i++) {
            Character ch = evenElements.pollFirst();
            if (i % 2 == 0) {
                result.append(ch);
            }
            evenElements.addLast(ch);
        }
        return result.toString();
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < descendingElements.size(); i++) {
            Character ch = descendingElements.pollLast();
            result.append(ch);
            descendingElements.addFirst(ch);
        }
        return result.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
