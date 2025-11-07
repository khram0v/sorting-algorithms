import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Array {
    private List<Integer> numbers = null;

    public Array() {
        numbers = new ArrayList<>();

        // numbers for an example
        numbers.add(5);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
    }

    public void printArray() {
        System.out.println();
        System.out.println(numbers);

        Main.returnToMainMenu();
    }

    /**
     * Prompts user to enter the total amount of numbers he wants to add.
     * It then iterates to prompt the user for each number, adding each to the list.
     *
     * @param sc the Scanner object used to read user input
     */
    public void addNumbers(Scanner sc) {
        int amount = 0;
        int number;

        // prompt to enter total amount of numbers
        System.out.println("How many numbers you want to add?");
        try {
            System.out.print("> ");
            amount = sc.nextInt();

            // checks if input is valid
            if (amount <= 0) {
                System.out.println("You can't add less than 1 number!");
                Main.returnToMainMenu();
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Sorry, buddy, only numbers allowed.");
            sc.nextLine();
            Main.returnToMainMenu();
            return;
        }

        // prompt for each numbers
        for (int i = 0; i < amount; i++) {
            try {
                System.out.print("Enter your number: ");
                number = sc.nextInt();
                numbers.add(number);
            } catch (InputMismatchException e) {
                System.out.println("Sorry, buddy, only numbers allowed.");
                sc.nextLine();
                Main.returnToMainMenu();
                return;
            }
        }

        System.out.println("Success! All your numbers are added!");
        Main.returnToMainMenu();
    }

    /**
     * Prompts user for an index (a position) of number he wants to remove.
     * Prompt is simplified for user, so indexes start from 1 instead of 0.
     *
     * @param sc the Scanner object used to read user input
     */
    public void removeNumber(Scanner sc) {
        int index = 0;

        System.out.println("Enter index of number you want to remove");
        System.out.printf("From 1 to %s\n > ", numbers.size());
        try {
            index = sc.nextInt();
            numbers.remove(index - 1);
        } catch (InputMismatchException e) {
            System.out.println("Sorry, buddy, only numbers allowed.");
            sc.nextLine();
            Main.returnToMainMenu();
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong index, bro.");
            Main.returnToMainMenu();
            return;
        }

        System.out.println("Success! Your number is removed!");
        Main.returnToMainMenu();
    }

    /**
     * Prompts user for an index of number he wants to replace. Then it prompts
     * for a new number to replace the old one.
     *
     * @param sc the Scanner object used to read user input
     */
    public void replaceNumber(Scanner sc) {
        int index = 0;

        // prompt for an index
        System.out.println("Enter index of number you want to replace");
        System.out.printf("From 1 to %s\n > ", numbers.size());
        try {
            index = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Sorry, buddy, only numbers allowed.");
            sc.nextLine();
            Main.returnToMainMenu();
            return;
        }

        // prompt for a new number
        System.out.println("Enter a number you want to put there");
        try {
            System.out.print("> ");
            numbers.set(index-1, sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Sorry, buddy, only numbers allowed.");
            sc.nextLine();
            Main.returnToMainMenu();
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong index, bro.");
            Main.returnToMainMenu();
            return;
        }

        System.out.println("Success! Your number is replaced!");
        Main.returnToMainMenu();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
