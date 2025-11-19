package io.github.khram0v.ui;

import io.github.khram0v.input.InputHandler;
import io.github.khram0v.model.SortableList;
import io.github.khram0v.sorting.*;
import io.github.khram0v.utils.SortingInfo;

public class SortingMenu {
    private final InputHandler handler;

    public SortingMenu(InputHandler handler) {
        this.handler = handler;
    }

    public void show(SortableList<?> list) {
        System.out.println("~~~ Sorting Menu ~~~");
        System.out.println("Current size: " + list.size());
        System.out.println("""
                1. Bubble sort
                2. Selection sort
                3. Insertion sort
                4. Merge sort
                5. Quick sort
                6. Print sorting info
                0. Exit to main menu
                """);
    }

    public <E extends Comparable<E>> void run(SortableList<E> list) {
        while (true) {
            handler.clearScreen();
            show(list); // display UI

            int choice = handler.readRangeChoice(0, 6, "> ");

            if (choice == 0) return; // go back

            SortingAlgorithm<E> algorithm = null;

            switch (choice) {
                case 1 -> algorithm = new BubbleSort<>();
                case 2 -> algorithm = new SelectionSort<>();
                case 3 -> algorithm = new InsertionSort<>();
                case 4 -> algorithm = new MergeSort<>();
                case 5 -> algorithm = new QuickSort<>();
                case 6 -> {
                    SortingInfo.printSortingInfo();
                    handler.waitForEnter();
                }
            }

            if (algorithm != null) {
                algorithm.sort(list.getElements());
                System.out.println("List sorted successfully!");
                System.out.println(list);
                handler.waitForEnter();
            }
        }
    }
}