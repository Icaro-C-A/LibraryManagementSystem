package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println("\n" + "=".repeat(30));
        System.out.println("LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=".repeat(30));
        System.out.println("1. Register a new Book");
        System.out.println("2. Remove a Book");
        System.out.println("3. Borrow a Book");
        System.out.println("6. Register a Reader");
        System.out.println("0. Exit Program");
        System.out.println("-".repeat(30));
        return readInt("Please select an option: ");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                scanner.nextLine();
                if (value < 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a whole number.");
                scanner.nextLine();
            }
        }
    }
}