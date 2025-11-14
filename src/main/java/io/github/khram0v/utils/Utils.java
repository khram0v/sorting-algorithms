package io.github.khram0v.utils;

import java.util.List;

public class Utils {
    public static <E> void swap(List<E> elements, int i, int j) {
        E temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
