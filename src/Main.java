import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Array array = new Array();

        while (true) {
            Main.displayMainMenu(sc, array);
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
                    Main.returnToMainMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, buddy, only numbers allowed.");
                sc.nextLine();

                Main.returnToMainMenu();
            }
        } while (!(order == 1 || order == 2)); // repeat until a valid choice is made

        // returns true if ascending order is chosen; otherwise, returns false
        return order == 1;
    }

    /**
     * Prints main menu and prompts user to choose the action.
     *
     * @param sc the Scanner object used to read user input.
     * @param array the `Array` instance used to pass it to other `Menu` methods.
     */
    public static void displayMainMenu(Scanner sc, Array array) {
        int choice = -1;

        do {
            // display menu of options
            System.out.println("\nWant to put some numbers here?");
            System.out.println("Or you're ready for sorting?");
            System.out.println("\t1. Array actions");
            System.out.println("\t2. Sorting");
            System.out.println("\t0. Exit");

            try {
                System.out.print("> ");
                choice = sc.nextInt();

                // checks if input is valid
                if (choice < 0 || choice > 2) {
                    System.out.println("Hey, try again, bro.");
                    Main.returnToMainMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, buddy, only numbers allowed.");
                sc.nextLine();

                Main.returnToMainMenu();
            }
        } while (choice < 0 || choice > 2);

        // performs an action based on user input
        switch (choice) {
            case 1:
                displayArrayMenu(sc, array);
                break;
            case 2:
                displaySortingMenu(sc, array);
                break;
            case 0:
                System.exit(0);
        }
    }

    /**
     * Prints menu with array actions and prompts user to choose the action.
     *
     * @param sc the Scanner object used to read user input.
     * @param array the `Array` instance used to perform actions with list.
     */
    private static void displayArrayMenu(Scanner sc, Array array) {
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
                    Main.returnToMainMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, buddy, only numbers allowed.");
                sc.nextLine();

                Main.returnToMainMenu();
            }
        } while (choice < 0 || choice > 4);

        // performs an action based on user input
        switch (choice) {
            case 1:
                array.printArray();
                break;
            case 2:
                array.addNumbers(sc);
                break;
            case 3:
                array.removeNumber(sc);
                break;
            case 4:
                array.replaceNumber(sc);
                break;
            case 0:
                displayMainMenu(sc, array);
                break;
        }

        // checks if user wants to exit this menu
        if (choice != 0) {
            displayArrayMenu(sc, array);
        }
    }

    /**
     * Prints menu with array actions and prompts user to choose the action.
     *
     * @param sc the Scanner object used to read user input.
     * @param array the `Array` instance containing the list of numbers to be sorted.
     */
    public static void displaySortingMenu(Scanner sc, Array array) {
        int choice = -1;
        boolean ascending;
        int numbersSize = array.getNumbers().size();

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
                    Main.returnToMainMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, buddy, only numbers allowed.");
                sc.nextLine();

                Main.returnToMainMenu();
            }
        } while (choice < 0 || choice > 7);

        // performs an action based on user input
        switch (choice) {
            case 1:
                ascending = Main.orderPrompt(sc);
                Sorting.bubbleSort(array, ascending);

                System.out.println("Success! All your numbers are sorted now by Bubble Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                Main.returnToMainMenu();
                break;
            case 2:
                ascending = Main.orderPrompt(sc);
                Sorting.selectionSort(array, ascending);

                System.out.println("Success! All your numbers are sorted now by Selection Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                Main.returnToMainMenu();
                break;
            case 3:
                ascending = Main.orderPrompt(sc);
                Sorting.insertionSort(array, ascending);

                System.out.println("Success! All your numbers are sorted now by Insertion Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                Main.returnToMainMenu();
                break;
            case 4:
                ascending = Main.orderPrompt(sc);
                Sorting.mergeSort(array, 0, numbersSize - 1, ascending);

                System.out.println("Success! All your numbers are sorted now by Merge Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                Main.returnToMainMenu();
                break;
            case 5:
                ascending = Main.orderPrompt(sc);
                Sorting.quickSort(array, 0, numbersSize - 1, ascending);

                System.out.println("Success! All your numbers are sorted now by Quick Sort!");
                System.out.println("Now you have your numbers in " + (ascending ? "ascending" : "descending") + " order.");

                Main.returnToMainMenu();
                break;
            case 6:
                Collections.shuffle(array.getNumbers());

                System.out.println("Success! You have mess again!");

                Main.returnToMainMenu();
                break;
            case 7:
                Sorting.showInfo();

                Main.returnToMainMenu();
                break;
            case 0:
                displayMainMenu(sc, array);
                break;
        }

        // checks if user wants to exit this menu
        if (choice != 0) {
            displaySortingMenu(sc, array);
        }
    }
}