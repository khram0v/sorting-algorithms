package io.github.khram0v.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    MergeSort<Integer> sort;

    @BeforeEach
    void setUp() {
        sort = new MergeSort<>();
    }

    @Test
    void sort_unsortedList_returnsSortedList() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2));

        sort.sort(list);

        assertEquals(List.of(1, 2, 3),  list);
    }

    @Test
    void sort_sortedList_remainsSorted() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));

        sort.sort(list);

        assertEquals(List.of(1, 2, 3), list);
    }

    @Test
    void sort_listWithDuplicates_sortCorrectly() {
        List<Integer> list = new ArrayList<>(List.of(2, 3, 4, 1, 4, 2));

        sort.sort(list);

        assertEquals(List.of(1, 2, 2, 3, 4, 4), list);
    }
}