package io.github.khram0v.app;

import io.github.khram0v.input.InputHandler;
import io.github.khram0v.model.SortableList;
import io.github.khram0v.sorting.Sorting;

import java.util.Collections;
import java.util.Scanner;

public class SortingApp {
    static SortableList<Integer> sortableList = new SortableList<>();
    static InputHandler input = new InputHandler();

    public static void main(String[] args) {

        while (true) {
            SortingApp.displayMainMenu(sortableList);
        }
    }


    public static void returnToMainMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n[Press Enter to return to main menu]");
        sc.nextLine();
    }

    public static boolean orderPrompt() {
        int order;

        System.out.println("\nChoose sorting order:");
        System.out.println("\t1. Ascending");
        System.out.println("\t2. Descending");

        order = input.readMenuChoice(1, 2, "> ");

        // returns true if ascending order is chosen; otherwise, returns false
        return order == 1;
    }

    public static void displayMainMenu(SortableList<Integer> sortableList) {
        int choice;

        System.out.println("\nWant to put some numbers here?");
        System.out.println("Or you're ready for sorting?");
        System.out.println("\t1. List actions");
        System.out.println("\t2. Sorting");
        System.out.println("\t0. Exit");

        choice = input.readMenuChoice(0, 2, "> ");

        switch (choice) {
            case 1 -> displayArrayMenu(sortableList);
            case 2 -> displaySortingMenu(sortableList);
            case 0 -> System.exit(0);
        }
    }

    private static void displayArrayMenu(SortableList<Integer> sortableList) {
        int choice;

        System.out.println("\nOkay, buddy, there's your array");
        System.out.println("What you want to do with it?");
        System.out.println("\t1. Look into it");
        System.out.println("\t2. Add numbers");
        System.out.println("\t3. Remove number");
        System.out.println("\t4. Replace number");
        System.out.println("\t0. Return to main menu");

        choice = input.readMenuChoice(0, 4, "> ");

        // TODO: Replace non-existent methods with new ones
        switch (choice) {
//            case 1 -> sortableList.printArray();
//            case 2 -> sortableList.addNumbers();
//            case 3 -> sortableList.removeNumber();
//            case 4 -> sortableList.replaceNumber();
            case 0 -> displayMainMenu(sortableList);
        }

        if (choice != 0) {
            displayArrayMenu(sortableList);
        }
    }

    public static void displaySortingMenu(SortableList<Integer> sortableList) {
        int choice;
        boolean ascending;
        int numbersSize = sortableList.size();

        System.out.println("\nOh, yeah, I see mess in your numbers. I can fix that!");
        System.out.println("What sorting algorithm do you prefer?");
        System.out.println("\t1. Bubble sort");
        System.out.println("\t2. Selection sort");
        System.out.println("\t3. Insertion sort");
        System.out.println("\t4. Merge sort");
        System.out.println("\t5. Quick sort");
        System.out.println("\t6. Shuffle");
        System.out.println("\t7. Learn about sorting algorithms");
        System.out.println("\t0. Return to main menu");

        choice = input.readMenuChoice(0, 7, "> ");

        switch (choice) {
            case 1 -> {
                ascending = SortingApp.orderPrompt();
                Sorting.bubbleSort(sortableList, ascending);

                System.out.println("Success! All your numbers are sorted now by Bubble Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                SortingApp.returnToMainMenu();
            }
            case 2 -> {
                ascending = SortingApp.orderPrompt();
                Sorting.selectionSort(sortableList, ascending);

                System.out.println("Success! All your numbers are sorted now by Selection Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                SortingApp.returnToMainMenu();
            }
            case 3 -> {
                ascending = SortingApp.orderPrompt();
                Sorting.insertionSort(sortableList, ascending);

                System.out.println("Success! All your numbers are sorted now by Insertion Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                SortingApp.returnToMainMenu();
            }
            case 4 -> {
                ascending = SortingApp.orderPrompt();
                Sorting.mergeSort(sortableList, 0, numbersSize - 1, ascending);

                System.out.println("Success! All your numbers are sorted now by Merge Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                SortingApp.returnToMainMenu();
            }
            case 5 -> {
                ascending = SortingApp.orderPrompt();
                Sorting.quickSort(sortableList, 0, numbersSize - 1, ascending);

                System.out.println("Success! All your numbers are sorted now by Quick Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                SortingApp.returnToMainMenu();
            }
            case 6 -> {
                Collections.shuffle(sortableList.getElements());

                System.out.println("Success! You have mess again!");

                SortingApp.returnToMainMenu();
            }
            case 7 -> {
                Sorting.showInfo();

                SortingApp.returnToMainMenu();
            }
            case 0 -> displayMainMenu(sortableList);
        }

        if (choice != 0) {
            displaySortingMenu(sortableList);
        }
    }
}