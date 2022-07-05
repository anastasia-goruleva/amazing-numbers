package numbers;

import numbers.output.LongFormat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        welcomeUsers();
        final var format = new LongFormat();

        while (true) {
            printInstructions();
            final var number = askRequest(scanner);
            System.out.println();
            try {
                format.display(number);
            } catch (IllegalArgumentException iae) {
                if ("0".equals(number)) {
                    break;
                }
                System.out.println(iae.getMessage());
            }
        }

        sayGoodbye();
    }

    private static String askRequest(Scanner scanner) {
        System.out.print("\nEnter a request: ");
        return scanner.next();
    }

    private static void welcomeUsers() {
        System.out.println("Welcome to Amazing Numbers!");
    }

    private static void printInstructions() {
        final var requests = new String[]{
                "- enter a natural number to know its properties",
                "- enter 0 to exit"
        };

        System.out.println("\nSupported requests:");
        System.out.printf("%s.\n", String.join(";\n", requests));
    }

    private static void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}
