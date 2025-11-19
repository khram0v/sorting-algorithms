package io.github.khram0v.input;

import io.github.khram0v.model.DataType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private final Scanner sc = new Scanner(System.in);

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public int readRangeChoice(int min, int max, String prompt) {
        int choice;
        do {
            choice = readInt(prompt);
            if (choice < min || choice > max) {
                System.out.printf("Please enter a number between %d and %d.%n", min, max);
            }
        } while (choice < min || choice > max);
        return choice;
    }

    public Object readValue(String prompt, DataType type) {
        while (true) {
            System.out.print(prompt);
            String raw = sc.nextLine().trim();
            try {
                return switch (type) {
                    case INTEGER -> Integer.parseInt(raw);
                    case DOUBLE -> Double.parseDouble(raw);
                    case STRING -> raw;
                };
            } catch (NumberFormatException e) {
                System.out.println("Invalid value, try again.");
            }
        }
    }

    public DataType askDataType() {
        System.out.print("""
            Choose data type:
            1. Integer
            2. Double
            3. String
            """);

        int choice = readRangeChoice(1, 3, "> ");

        return switch (choice) {
            case 1 -> DataType.INTEGER;
            case 2 -> DataType.DOUBLE;
            case 3 -> DataType.STRING;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    public void waitForEnter() {
        System.out.print("Press Enter to continue...");
        sc.nextLine();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(); // avoids weird cursor artifacts
    }
}