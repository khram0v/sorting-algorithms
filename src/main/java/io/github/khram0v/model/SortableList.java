package io.github.khram0v.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortableList<E> {
    private final List<E> elements;

    public SortableList() {
        elements = new ArrayList<>();
    }

    public SortableList(List<E> initialElements) {
        this.elements = new ArrayList<>(initialElements);
    }

    public void add(E element) {
        elements.add(element);
    }

    public void removeByElement(E element) {
        elements.remove(element);
    }

    public boolean removeByIndex(int index) {
        if (index < 0 || index >= elements.size()) return false;
        elements.remove(index);
        return true;
    }

    public boolean replaceAtIndex(int index, E newElement) {
        if (index < 0 || index >= elements.size()) return false;
        elements.set(index, newElement);
        return true;
    }

    public List<E> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public int size() {
        return elements.size();
    }
}
