package io.github.khram0v.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private final Scanner sc;

    public InputHandler() {
        sc = new Scanner(System.in);
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clear invalid input
            }
        }
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + "(y/n): ");
            String input = sc.next().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) return true;
            if (input.equals("n") || input.equals("no")) return false;
            System.out.println("Please type 'y' or 'n'.");
        }
    }

    public int readMenuChoice(int min, int max, String prompt) {
        int choice;
        do {
            choice = readInt(prompt);
            if (choice < min || choice > max) {
                System.out.printf("Please enter a number between %d and %d.%n", min, max);
            }
        } while (choice < min || choice > max);
        return choice;
    }
}
