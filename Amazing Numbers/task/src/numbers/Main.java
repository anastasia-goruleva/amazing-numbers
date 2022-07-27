package numbers;

import numbers.exceptions.ExitRequestException;
import numbers.exceptions.NoUserInputException;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<String> INSTRUCTIONS = List.of(
            "Supported requests:",
            "- enter a natural number to know its properties;",
            "- enter two natural numbers to obtain the properties of the list:",
            " * the first parameter represents a starting number;",
            " * the second parameter shows how many consecutive numbers are to be processed;",
            "- two natural numbers and properties to search for;",
            "- a property preceded by minus must not be present in numbers;",
            "- separate the parameters with one space;",
            "- enter 0 to exit."
    );

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        welcomeUsers();
        printInstructions();

        while (true) {
            final var requestScanner = new Scanner(askRequest(scanner));
            final var inputProcessing = new InputProcessing(requestScanner);

            System.out.println();

            try {
                inputProcessing.process();
            } catch (ExitRequestException e) {
                break;
            } catch (NoUserInputException e) {
                printInstructions();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        sayGoodbye();
    }

    private static String askRequest(Scanner scanner) {
        System.out.print("\nEnter a request: ");
        return scanner.nextLine().toUpperCase();
    }

    private static void welcomeUsers() {
        System.out.println("Welcome to Amazing Numbers!\n");
    }

    private static void printInstructions() {
        INSTRUCTIONS.forEach(System.out::println);
    }

    private static void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}
