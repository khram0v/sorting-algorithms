package io.github.khram0v.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortableListTest {
    SortableList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SortableList<>();
    }

    @Test
    void add_whenCalled_addsElementToList() {
        list.add(10);

        assertEquals(1, list.size());
        assertEquals(10, list.getElements().getFirst());
    }

    @Test
    void remove_validIndex_removesElement() {
        list.add(3);
        list.add(10);

        assertTrue(list.remove(0));
        assertEquals(1, list.size());
        assertEquals(10, list.getElements().getFirst());
    }

    @Test
    void remove_invalidIndex_returnsFalseWithoutChanges() {
        list.add(4);
        list.add(9);

        assertFalse(list.remove(5));
        assertEquals(2, list.size());
        assertEquals(4, list.getElements().getFirst());
    }

    @Test
    void replace_validIndex_replacesElement() {
        list.add(10);
        list.add(15);

        assertTrue(list.replace(1, 20));
        assertEquals(2, list.size());
        assertEquals(20, list.getElements().get(1));
    }

    @Test
    void replace_invalidIndex_returnsFalseWithoutChanges() {
        list.add(10);
        list.add(12);

        assertFalse(list.replace(5, 100));
        assertEquals(2, list.size());
        assertEquals(10, list.getElements().getFirst());
    }

    @Test
    void reverse_threeElements_reverseList() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.reverse();

        assertEquals(List.of(3, 2, 1), list.getElements());
    }

    @Test
    void partialReverse_validIndices_reversePartOfList() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.reverse(0, 2);

        assertEquals(List.of(3, 2, 1, 4), list.getElements());
    }

    @Test
    void partialReverse_invalidIndices_returnWithoutChanges() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.reverse(2, 0);

        assertEquals(List.of(1, 2, 3, 4), list.getElements());
    }
}