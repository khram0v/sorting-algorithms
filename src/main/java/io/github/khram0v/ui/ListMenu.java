package io.github.khram0v.ui;

import io.github.khram0v.input.InputHandler;
import io.github.khram0v.model.DataType;
import io.github.khram0v.model.SortableList;

public class ListMenu {
    private final InputHandler handler;

    public ListMenu(InputHandler handler) {
        this.handler = handler;
    }

    public void show(SortableList<?> list) {
        System.out.println("~~~ List Menu ~~~");
        System.out.println("Current size: " + list.size());
        System.out.println("""             
                1. Add element
                2. Remove element
                3. Replace element
                4. Shuffle list
                5. Reverse list
                6. Print list
                0. Exit to main menu
                """);
    }

    public <E extends Comparable<E>> void run(SortableList<E> list, DataType type) {
        while (true) {
            handler.clearScreen();
            show(list); // display UI

            int choice = handler.readRangeChoice(0, 6, "> ");

            if (choice == 0) return; // go back

            switch (choice) {
                case 1 -> addElement(list, type);
                case 2 -> removeElement(list);
                case 3 -> replaceElement(list, type);
                case 4 -> shuffleList(list);
                case 5 -> reverseList(list);
                case 6 -> printList(list);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <E extends Comparable<E>> void addElement(SortableList<E> list, DataType type) {
        Object value = handler.readValue("Enter value: ", type);
        list.add((E) value);
        System.out.println("Added!");
    }

    private <E extends Comparable<E>> void removeElement(SortableList<E> list) {
        if (list.size() == 0) {
            System.out.println("List is empty.");
            handler.waitForEnter();
            return;
        }

        int index = handler.readRangeChoice(0, list.size() - 1, "Index: ");

        if (list.remove(index)) System.out.println("Removed!");
        else System.out.println("Index out of range.");
    }

    @SuppressWarnings("unchecked")
    private <E extends Comparable<E>> void replaceElement(SortableList<E> list, DataType type) {
        if (list.size() == 0) {
            System.out.println("List is empty.");
            handler.waitForEnter();
            return;
        }

        int index = handler.readRangeChoice(0, list.size() - 1, "Index: ");
        Object newValue = handler.readValue("New value: ", type);

        if (list.replace(index, (E) newValue)) System.out.println("Replaced");
        else System.out.println("Index out of range.");
    }

    private <E extends Comparable<E>> void shuffleList(SortableList<E> list) {
        list.shuffle();
        System.out.println("Shuffled!");
    }

    private <E extends Comparable<E>> void reverseList(SortableList<E> list) {
        list.reverse();
        System.out.println("Reversed!");
    }

    private <E extends Comparable<E>> void printList(SortableList<E> list) {
        System.out.println(list);
    }
}