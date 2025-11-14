package io.github.khram0v.sorting;

import io.github.khram0v.utils.Utils;

import java.util.List;

public class BubbleSort<E extends Comparable<E>> implements SortingAlgorithm<E> {
    @Override
    public void sort(List<E> elements) {
        int size = elements.size();

        // Outer loop controls the number of iterations needed to complete sorting
        for (int i = 0; i < size - 1; i++) {
            // Inner loop performs comparison and swapping for each iteration
            for (int j = 0; j < size - i - 1; j++) {
                if (elements.get(j).compareTo(elements.get(j + 1)) > 0) {
                    Utils.swap(elements, j, j + 1);
                }
            }
        }
    }
}
