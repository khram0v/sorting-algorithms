package io.github.khram0v.sorting;

import java.util.List;

public class InsertionSort<E extends Comparable<E>> implements SortingAlgorithm<E> {
    @Override
    public void sort(List<E> elements) {
        int size = elements.size();

        // Start from the second element and iterate through the list
        for (int i = 1; i < size; i++) {
            E key = elements.get(i);
            int j = i - 1;

            // Shift elements of the sorted segment to the right to make space for the key
            while (j >= 0 && elements.get(j).compareTo(key) > 0) {
                // Move larger element one position ahead
                elements.set(j + 1, elements.get(j));
                j--;
            }
            // Place the key in its correct position
            elements.set(j + 1, key);
        }
    }
}
