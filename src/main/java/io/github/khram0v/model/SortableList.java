package io.github.khram0v.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortableList<E extends Comparable<E>> {
    private final List<E> elements;

    public SortableList() {
        elements = new ArrayList<>();
    }

    public void add(E element) {
        elements.add(element);
    }

    public boolean remove(int index) {
        if (index < 0 || index >= elements.size()) return false;
        elements.remove(index);
        return true;
    }

    public boolean replace(int index, E newElement) {
        if (index < 0 || index >= elements.size()) return false;
        elements.set(index, newElement);
        return true;
    }

    public void reverse() {
        reverse(0, elements.size() - 1);
    }

    public void reverse(int start, int end) {
        if (start < 0 || end > elements.size() || start >= end) return;

        while (start < end) {
            E temp = elements.get(start);
            elements.set(start, elements.get(end));
            elements.set(end, temp);
            start++;
            end--;
        }
    }

    public void shuffle() {
        Collections.shuffle(elements);
    }

    public List<E> getElements() {
        return elements;
    }

    public int size() {
        return elements.size();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}