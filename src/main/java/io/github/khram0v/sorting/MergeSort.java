package io.github.khram0v.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<E extends Comparable<E>> implements SortingAlgorithm<E> {
    @Override
    public void sort(List<E> elements) {
        mergeSort(elements, 0, elements.size() - 1);
    }

    private void mergeSort(List<E> elements, int left, int right) {
        // Check if there are at least two elements to sort
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort both halves of the list
            mergeSort(elements, left, mid);
            mergeSort(elements, mid + 1, right);
            // Merge them back together
            merge(elements, left, mid, right);
        }
    }

    private void merge(List<E> elements, int left, int mid, int right) {
        int leftSize = mid - left + 1; // size of the left sub-list
        int rightSize = right - mid;    // size of the right sub-list

        // Temporary lists to hold left and right sub-lists
        List<E> leftList = new ArrayList<>();
        List<E> rightList = new ArrayList<>();

        // Fill leftList and rightList
        for (int i = 0; i < leftSize; i++) {
            leftList.add(elements.get(left + i));
        }
        for (int i = 0; i < rightSize; i++) {
            rightList.add(elements.get(mid + 1 + i));
        }

        // Initialize pointers for leftList (i), rightList (j) and original list (k)
        int i = 0, j = 0, k = left;

        // Merge temporary lists back into the original list
        while (i < leftSize && j < rightSize) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                // Add element from leftList to original list
                elements.set(k++, leftList.get(i++));
            } else {
                // Add element from rightList to original list
                elements.set(k++, rightList.get(j++));
            }
        }

        // Copy any remaining elements from both lists
        while (i < leftSize) {
            elements.set(k++, leftList.get(i++));
        }
        while (j < rightSize) {
            elements.set(k++, rightList.get(j++));
        }
    }
}
