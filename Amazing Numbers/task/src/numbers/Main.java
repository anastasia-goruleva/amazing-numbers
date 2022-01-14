package numbers;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var errorCheckers = List.of(new NaturalNumberChecker());

        final var propertyCheckers = List.of(
                new EvenNumberChecker(),
                new OddNumberChecker(),
                new BuzzNumberChecker(),
                new DuckNumberChecker(),
                new PalindromicNumberChecker());

        final var scanner = new Scanner(System.in);

        welcomeUsers();

        while (true) {
            printInstructions();
            final var number = askRequest(scanner);
            System.out.println();
            try {
                errorCheckers.forEach(checker -> checker.throwException(number));
                System.out.printf("Properties of %s\n", number);
                propertyCheckers.forEach(checker -> checker.accept(number));
            } catch (IllegalArgumentException iae) {
                if ("0".equals(number)) {
                    break;
                } else {
                    System.out.println(iae.getMessage());
                }
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
        final var requests = new String[] {
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
