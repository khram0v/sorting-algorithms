package io.github.khram0v.app;

import io.github.khram0v.model.SortableCollection;
import io.github.khram0v.sorting.Sorting;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SortingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortableCollection sortableCollection = new SortableCollection();

        while (true) {
            SortingApp.displayMainMenu(sc, sortableCollection);
        }
    }

    /**
     * Prompts user to press [Enter] key to return to main menu.
     */
    public static void returnToMainMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n[Press Enter to return to main menu]");
        sc.nextLine();
    }

    /**
     * Prompts user to choose sorting order.
     *
     * @param sc the Scanner object used to read user input.
     * @return true if ascending order is chosen; otherwise false.
     */
    public static boolean orderPrompt(Scanner sc) {
        int order = -1;

        do {
            // display menu of options
            System.out.println("\nChoose sorting order:");
            System.out.println("\t1. Ascending");
            System.out.println("\t2. Descending");

            try {
                System.out.print("> ");
                order = sc.nextInt();

                // checks if input is valid
                if (!(order == 1 || order == 2)) {
                    System.out.println("Hey, try again, bro.");
                    SortingApp.returnToMainMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, buddy, only numbers allowed.");
                sc.nextLine();

                SortingApp.returnToMainMenu();
            }
        } while (!(order == 1 || order == 2)); // repeat until a valid choice is made

        // returns true if ascending order is chosen; otherwise, returns false
        return order == 1;
    }

    /**
     * Prints main menu and prompts user to choose the action.
     *
     * @param sc the Scanner object used to read user input.
     * @param sortableCollection the `io.github.khram0v.model.Array` instance used to pass it to other `Menu` methods.
     */
    public static void displayMainMenu(Scanner sc, SortableCollection sortableCollection) {
        int choice = -1;

        do {
            // display menu of options
            System.out.println("\nWant to put some numbers here?");
            System.out.println("Or you're ready for sorting?");
            System.out.println("\t1. io.github.khram0v.model.Array actions");
            System.out.println("\t2. io.github.khram0v.sorting.Sorting");
            System.out.println("\t0. Exit");

            try {
                System.out.print("> ");
                choice = sc.nextInt();

                // checks if input is valid
                if (choice < 0 || choice > 2) {
                    System.out.println("Hey, try again, bro.");
                    SortingApp.returnToMainMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, buddy, only numbers allowed.");
                sc.nextLine();

                SortingApp.returnToMainMenu();
            }
        } while (choice < 0 || choice > 2);

        // performs an action based on user input
        switch (choice) {
            case 1:
                displayArrayMenu(sc, sortableCollection);
                break;
            case 2:
                displaySortingMenu(sc, sortableCollection);
                break;
            case 0:
                System.exit(0);
        }
    }

    /**
     * Prints menu with array actions and prompts user to choose the action.
     *
     * @param sc the Scanner object used to read user input.
     * @param sortableCollection the `io.github.khram0v.model.Array` instance used to perform actions with list.
     */
    private static void displayArrayMenu(Scanner sc, SortableCollection sortableCollection) {
        int choice = -1;

        do {
            // display menu of options
            System.out.println("\nOkay, buddy, there's your array");
            System.out.println("What you want to do with it?");
            System.out.println("\t1. Look into it");
            System.out.println("\t2. Add numbers");
            System.out.println("\t3. Remove number");
            System.out.println("\t4. Replace number");
            System.out.println("\t0. Return to main menu");

            try {
                System.out.print("> ");
                choice = sc.nextInt();

                // checks if input is valid
                if (choice < 0 || choice > 4) {
                    System.out.println("Hey, try again, bro.");
                    SortingApp.returnToMainMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, buddy, only numbers allowed.");
                sc.nextLine();

                SortingApp.returnToMainMenu();
            }
        } while (choice < 0 || choice > 4);

        // performs an action based on user input
        switch (choice) {
            case 1:
                sortableCollection.printArray();
                break;
            case 2:
                sortableCollection.addNumbers(sc);
                break;
            case 3:
                sortableCollection.removeNumber(sc);
                break;
            case 4:
                sortableCollection.replaceNumber(sc);
                break;
            case 0:
                displayMainMenu(sc, sortableCollection);
                break;
        }

        // checks if user wants to exit this menu
        if (choice != 0) {
            displayArrayMenu(sc, sortableCollection);
        }
    }

    /**
     * Prints menu with array actions and prompts user to choose the action.
     *
     * @param sc the Scanner object used to read user input.
     * @param sortableCollection the `io.github.khram0v.model.Array` instance containing the list of numbers to be sorted.
     */
    public static void displaySortingMenu(Scanner sc, SortableCollection sortableCollection) {
        int choice = -1;
        boolean ascending;
        int numbersSize = sortableCollection.getNumbers().size();

        do {
            // display menu of options
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

            try {
                System.out.print("> ");
                choice = sc.nextInt();

                // checks if input is valid
                if (choice < 0 || choice > 7) {
                    System.out.println("Hey, try again, bro.");
                    SortingApp.returnToMainMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, buddy, only numbers allowed.");
                sc.nextLine();

                SortingApp.returnToMainMenu();
            }
        } while (choice < 0 || choice > 7);

        // performs an action based on user input
        switch (choice) {
            case 1:
                ascending = SortingApp.orderPrompt(sc);
                Sorting.bubbleSort(sortableCollection, ascending);

                System.out.println("Success! All your numbers are sorted now by Bubble Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                SortingApp.returnToMainMenu();
                break;
            case 2:
                ascending = SortingApp.orderPrompt(sc);
                Sorting.selectionSort(sortableCollection, ascending);

                System.out.println("Success! All your numbers are sorted now by Selection Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                SortingApp.returnToMainMenu();
                break;
            case 3:
                ascending = SortingApp.orderPrompt(sc);
                Sorting.insertionSort(sortableCollection, ascending);

                System.out.println("Success! All your numbers are sorted now by Insertion Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                SortingApp.returnToMainMenu();
                break;
            case 4:
                ascending = SortingApp.orderPrompt(sc);
                Sorting.mergeSort(sortableCollection, 0, numbersSize - 1, ascending);

                System.out.println("Success! All your numbers are sorted now by Merge Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                SortingApp.returnToMainMenu();
                break;
            case 5:
                ascending = SortingApp.orderPrompt(sc);
                Sorting.quickSort(sortableCollection, 0, numbersSize - 1, ascending);

                System.out.println("Success! All your numbers are sorted now by Quick Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                SortingApp.returnToMainMenu();
                break;
            case 6:
                Collections.shuffle(sortableCollection.getNumbers());

                System.out.println("Success! You have mess again!");

                SortingApp.returnToMainMenu();
                break;
            case 7:
                Sorting.showInfo();

                SortingApp.returnToMainMenu();
                break;
            case 0:
                displayMainMenu(sc, sortableCollection);
                break;
        }

        // checks if user wants to exit this menu
        if (choice != 0) {
            displaySortingMenu(sc, sortableCollection);
        }
    }
}