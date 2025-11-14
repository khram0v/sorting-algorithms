package io.github.khram0v.sorting;

import java.util.List;

public interface SortingAlgorithm<E extends Comparable<E>> {
    void sort(List<E> elements);
}
