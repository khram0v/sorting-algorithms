package io.github.khram0v.sorting;

import io.github.khram0v.utils.Utils;

import java.util.List;

public class QuickSort<E extends Comparable<E>> implements SortingAlgorithm<E> {
    @Override
    public void sort(List<E> elements) {
        quickSort(elements, 0, elements.size() - 1);
    }

    private void quickSort(List<E> elements, int low, int high) {
        // Check if current segment has more than one element
        if (low < high) {
            // Partition the list and get index of the pivot
            int pivotIndex = partition(elements, low, high);

            // Recursively sort both sub-lists
            quickSort(elements, low, pivotIndex - 1);
            quickSort(elements, pivotIndex + 1, high);
        }
    }

    private int partition(List<E> elements, int low, int high) {
        // Set pivot to the last element in current segment of the list
        E pivot = elements.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (elements.get(j).compareTo(pivot) < 0) {
                i++;
                Utils.swap(elements, i, j);
            }
        }
        // Place pivot in its correct position
        Utils.swap(elements, i + 1, high);

        return i + 1;
    }
}
