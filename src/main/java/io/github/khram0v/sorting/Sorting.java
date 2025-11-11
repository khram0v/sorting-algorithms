package io.github.khram0v.sorting;

import io.github.khram0v.model.SortableCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    /**
     * Sorts the list in ascending or descending order using the Bubble Sort algorithm.
     *
     * <p>This is a comparison-based algorithm that repeatedly steps through the list,
     * compares adjacent elements, and swaps them if they are in the wrong order.
     * The process repeats until the entire list is sorted.</p>
     *
     * @param sortableCollection the `io.github.khram0v.model.Array` instance containing the list of numbers to be sorted.
     * @param ascending if true, sorts in ascending order; if false, sorts in descending order.
     */
    public static void bubbleSort(SortableCollection sortableCollection, boolean ascending) {
        // retrieve the list of numbers from the io.github.khram0v.model.Array instance
        List<Integer> numbers = sortableCollection.getNumbers();
        int size = numbers.size();

        // outer loop controls the number of passes needed to complete sorting
        for (int i = 0; i < size - 1; i++) {
            // inner loop performs comparison and swapping for each pass
            for (int j = 0; j < size - i - 1; j++) {
                // check if elements are in correct order based on desired sorting order
                if ((ascending && numbers.get(j) > numbers.get(j + 1)) ||
                        (!ascending && numbers.get(j) < numbers.get(j + 1))) {
                    // swaps elements if they are in the wrong order
                    Collections.swap(numbers, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list in ascending or descending order using the Selection Sort algorithm.
     *
     * <p>This algorithm divides the list into a sorted and an unsorted section, then repeatedly
     * selects the smallest (or largest) element from the unsorted section and places it at
     * the end of the sorted section.</p>
     *
     * @param sortableCollection the `io.github.khram0v.model.Array` instance containing the list of numbers to be sorted.
     * @param ascending if true, sorts in ascending order; if false, sorts in descending order.
     */
    public static void selectionSort(SortableCollection sortableCollection, boolean ascending) {
        // retrieve the list of numbers from the io.github.khram0v.model.Array instance
        List<Integer> numbers = sortableCollection.getNumbers();
        int size = numbers.size();

        // outer loop controls the number of passes needed to complete sorting
        for (int i = 0; i < size - 1; i++) {
            // assume the current index has the smallest (or largest) element for the current pass
            int targetIndex = i;

            // inner loop finds the minimum (or maximum) element in the unsorted portion of the list
            for (int j = i + 1; j < size; j++) {
                // update targetIndex if a smaller (or larger) element is found, depending on order
                if ((ascending && numbers.get(j) < numbers.get(targetIndex)) ||
                        (!ascending && numbers.get(j) > numbers.get(targetIndex))) {
                    targetIndex = j;
                }
            }

            // swap the found minimum (or maximum) element with the current element at index i
            Collections.swap(numbers, targetIndex, i);
        }
    }

    /**
     * Sorts the list in ascending or descending order using the Insertion Sort algorithm.
     *
     * <p>Insertion Sort builds the final sorted list one element at a time, repeatedly
     * taking the next element from the unsorted section and inserting it into the
     * correct position in the sorted section.</p>
     *
     * @param sortableCollection the `io.github.khram0v.model.Array` instance containing the list of numbers to be sorted.
     * @param ascending if true, sorts in ascending order; if false, sorts in descending order.
     */
    public static void insertionSort(SortableCollection sortableCollection, boolean ascending) {
        // retrieve the list of numbers from the io.github.khram0v.model.Array instance
        List<Integer> numbers = sortableCollection.getNumbers();
        int size = numbers.size();

        // start from the second element and iterate through the list
        for (int i = 1; i < size; i++) {
            // store the current element (key) to be compared
            int key = numbers.get(i);
            int j = i - 1;

            // shift elements of the sorted segment that are greater (or smaller) than the key
            // to the right to make space for the key
            while (j >= 0 && ((ascending && numbers.get(j) > key) || (!ascending && numbers.get(j) < key))) {
                // move the larger (or smaller) element one position ahead
                numbers.set(j + 1, numbers.get(j));
                // go to the previous element
                j--;
            }
            // place the key in its correct position in the sorted segment
            numbers.set(j + 1, key);
        }
    }

    /**
     * Sorts the list in ascending or descending order using the Merge Sort algorithm.
     *
     * <p>Merge Sort is a divide-and-conquer algorithm that recursively splits the list into
     * halves, sorts each half, and merges the sorted halves back together.</p>
     *
     * @param sortableCollection the `io.github.khram0v.model.Array` instance containing the list of numbers to be sorted.
     * @param left the starting index of the sub-list to sort.
     * @param right the ending index of the sub-list to sort.
     * @param ascending if true, sorts in ascending order; if false, sorts in descending order.
     */
    public static void mergeSort(SortableCollection sortableCollection, int left, int right, boolean ascending) {
        // check if the left index is less than the right index to ensure there are at least two elements to sort
        if (left < right) {
            int mid = (left + right) / 2;

            // recursively sort the left half of the list
            mergeSort(sortableCollection, left, mid, ascending);
            // recursively sort the right half of the list
            mergeSort(sortableCollection, mid + 1, right, ascending);
            // merge two sorted halves back together
            merge(sortableCollection, left, mid, right, ascending);
        }
    }

    /**
     * Merges two sorted halves of the list into a single sorted list.
     *
     * @param sortableCollection the `io.github.khram0v.model.Array` instance containing the list of numbers to be sorted.
     * @param left the starting index of the left half.
     * @param mid the ending index of the left half, one less than the start index of the right half.
     * @param right the ending index of the right half.
     * @param ascending if true, merges in ascending order; if false, merges in descending order.
     */
    private static void merge(SortableCollection sortableCollection, int left, int mid, int right, boolean ascending) {
        // retrieve the list of numbers from the io.github.khram0v.model.Array instance
        List<Integer> numbers = sortableCollection.getNumbers();

        int n1 = mid - left + 1; // size of the left sub-list
        int n2 = right - mid;    // size of the left sub-list

        // create temporary lists to hold left and right sub-lists
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        // Fill leftList and rightList
        for (int i = 0; i < n1; i++) {
            leftList.add(numbers.get(left + i));
        }
        for (int i = 0; i < n2; i++) {
            rightList.add(numbers.get(mid + 1 + i));
        }

        // initialize pointers for leftList (i), rightList (j), and the original list (k)
        int i = 0, j = 0, k = left;

        // Merge the temporary lists back into the original list based on the order
        while (i < n1 && j < n2) {
            // compare elements from leftList and rightList based on the specified order
            if (ascending ? leftList.get(i) <= rightList.get(j) : leftList.get(i) >= rightList.get(j)) {
                // add element from leftList to original list
                numbers.set(k++, leftList.get(i++));
            } else {
                // add element from rightList to original list
                numbers.set(k++, rightList.get(j++));
            }
        }

        // Copy any remaining elements of leftList, if any
        while (i < n1) {
            numbers.set(k++, leftList.get(i++));
        }

        // Copy any remaining elements of rightList, if any
        while (j < n2) {
            numbers.set(k++, rightList.get(j++));
        }
    }

    /**
     * Sorts the list in ascending or descending order using the Quick Sort algorithm.
     *
     * <p>Quick Sort selects a pivot element and partitions the list into two halves such
     * that elements less than the pivot are on one side and those greater are on the other.
     * It then recursively sorts each half.</p>
     *
     * @param sortableCollection the `io.github.khram0v.model.Array` instance containing the list of numbers to be sorted.
     * @param low the starting index of the portion of the sortableCollection to sort.
     * @param high the ending index of the portion of the sortableCollection to sort.
     * @param ascending if true, sorts in ascending order; if false, sorts in descending order.
     */
    public static void quickSort(SortableCollection sortableCollection, int low, int high, boolean ascending) {
        // check if the current segment has more than one element
        if (low < high) {
            // partition the list and get the index of the pivot
            int pivotIndex = partition(sortableCollection, low, high, ascending);

            // recursively sort the left sub-list
            quickSort(sortableCollection, low, pivotIndex - 1, ascending);
            // recursively sort the right sub-list
            quickSort(sortableCollection, pivotIndex + 1, high, ascending);
        }
    }

    /**
     * Partitions a section of the sortableCollection around a pivot element, organizing elements in either
     * ascending or descending order based on the pivot's value. Elements less than the pivot
     * are moved to its left, and elements greater than the pivot to its right (or vice versa).
     *
     * @param sortableCollection the `io.github.khram0v.model.Array` instance containing the list of numbers to be sorted.
     * @param low the starting index of the section to partition.
     * @param high the ending index of the section to partition, where the pivot is located.
     * @param ascending if true, partitions the list for ascending order; if false, partitions for descending order.
     * @return the index position of the pivot after partitioning. Serves as a dividing point for further sorting.
     */
    private static int partition(SortableCollection sortableCollection, int low, int high, boolean ascending) {
        // retrieve the list of numbers from the io.github.khram0v.model.Array instance
        List<Integer> numbers = sortableCollection.getNumbers();

        // set the pivot to the last element in the current segment of the list
        int pivot = numbers.get(high);
        int i = low - 1;

        // loop through the elements from low to high (excluding the pivot)
        for (int j = low; j < high; j++) {
            // determine if the current element should be swapped based on sorting order
            if (ascending ? numbers.get(j) < pivot : numbers.get(j) > pivot) {
                i++;
                // swap the current element with the element at index i
                Collections.swap(numbers, i, j);
            }
        }
        // swap the pivot element with the element at index i + 1 to place it in the correct position
        Collections.swap(numbers, i + 1, high);

        // return the index of the pivot after placing it in the correct position
        return i + 1;
    }

    public static void showInfo() {
        System.out.println("\n\nSo, here's some information about all these sorting algorithms.\n");

        System.out.println("1. Bubble Sort.");
        System.out.println("""
            This is a comparison-based algorithm. It means that it's based on element comparing.
            It repeatedly steps through the list, compares adjacent elements and swaps them if
            they are in the wrong order. And it repeats until the list is sorted.
        Big O               |    Best    |         |   Average   |        |    Worst    |
        Notation:                O(n)                   O(n^2)                 O(n^2)
        """);

        System.out.println("2. Selection Sort.");
        System.out.println("""
            This sorting algorithm is comparison-based as well. It divides the list into a sorted
            and an unsorted region. It repeatedly selects the smallest (or largest) element from
            an unsorted region and moves it to the end of the sorted region.
        Big O               |    Best    |         |   Average   |        |    Worst    |
        Notation:               O(n^2)                  O(n^2)                 O(n^2)
        """);

        System.out.println("3. Insertion Sort.");
        System.out.println("""
            This sorting algorithm is also comparison-based. It works by building the sorted output
            one item at a time. For each element, the algorithm compares it with the elements in the
            sorted region, shifting them right if they are greater than the current element, and
            inserts the element in its correct position.
        Big O               |    Best    |         |   Average   |        |    Worst    |
        Notation:                O(n)                   O(n^2)                 O(n^2)
        """);

        System.out.println("4. Merge Sort.");
        System.out.println("""
            This is divide-and-conquer algorithm. It recursively divides the list into two halves,
            sorts each half, and the then merges the sorted halves to produce the final output.
            The `merge` function combines two sorted sub-lists into a single sorted sortableCollection.
        Big O               |    Best    |         |   Average   |        |    Worst    |
        Notation:             O(n*log(n))            O(n*log(n))            O(n*log(n))
        """);

        System.out.println("5. Quick Sort.");
        System.out.println("""
            Another divide-and-conquer algorithm. It works by selecting a ‘pivot’ element from
            the list and partitioning the other elements into two groups, according to whether
            they are less or greater than the pivot. These sub-lists sorted recursively.
        Big O               |    Best    |         |   Average   |        |    Worst    |
        Notation:             O(n*log(n))            O(n*log(n))               O(n^2)
        """);
    }
}