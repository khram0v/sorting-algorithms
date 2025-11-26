package io.github.khram0v.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    void swap_validIndices_swapsElements() {
        List<Integer> list = new ArrayList<>(List.of(2, 1, 3));

        Utils.swap(list, 0, 1);

        assertEquals(List.of(1, 2, 3), list);
    }
}