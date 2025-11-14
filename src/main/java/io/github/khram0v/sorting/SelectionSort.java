package io.github.khram0v.sorting;

import io.github.khram0v.utils.Utils;

import java.util.List;

public class SelectionSort<E extends Comparable<E>> implements SortingAlgorithm<E> {
    @Override
    public void sort(List<E> elements) {
        int size = elements.size();

        // Outer loop controls number of iterations needed to complete sorting
        for (int i = 0; i < size - 1; i++) {
            // Assume the current index has the smallest element for the current iteration
            int minIndex = i;

            // Inner loop finds the minimum element in the unsorted portion of the list
            for (int j = i + 1; j < size; j++) {
                if (elements.get(j).compareTo(elements.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Utils.swap(elements, minIndex, i);
        }
    }
}
