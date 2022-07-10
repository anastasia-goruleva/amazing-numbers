package numbers;

import numbers.exceptions.ExitRequestException;
import numbers.exceptions.NaturalNumberException;
import numbers.exceptions.NoUserInputException;
import numbers.exceptions.UnexpectedInputException;
import numbers.inputchecks.ExitRequestCheck;
import numbers.inputchecks.NaturalNumberCheck;
import numbers.inputchecks.StateInputCheck;
import numbers.output.LongFormat;
import numbers.states.InitialState;
import numbers.states.State;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static numbers.ValueContainer.Value;

public class Main {
    private static final List<String> INSTRUCTIONS = List.of(
            "Supported requests:",
            "- enter a natural number to know its properties;",
            "- enter two natural numbers to obtain the properties of the list:",
            " * the first parameter represents a starting number;",
            " * the second parameter shows how many consecutive numbers are to be processed;",
            "- separate the parameters with one space;",
            "- enter 0 to exit."
    );

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var format = new LongFormat();
        final var valueChecks = List.of(
                new ExitRequestCheck(),
                new NaturalNumberCheck()
        );

        welcomeUsers();
        printInstructions();

        while (true) {
            final var requestScanner = new Scanner(askRequest(scanner));
            State currentState = new InitialState();
            try {
                while (requestScanner.hasNext()) {
                    // read data
                    final var value = getIntegerInput(requestScanner);
                    // check input
                    checkInput(value, currentState, valueChecks);
                    // go to next state
                    currentState = currentState.getNextState(value);
                }

                currentState.processData();
            } catch (ExitRequestException e) {
                break;
            } catch (NaturalNumberException e) {
                System.out.println("Natural number expected");
            } catch (NoUserInputException e) {
                printInstructions();
            } catch (UnexpectedInputException e) {
                System.out.println(e.getMessage());
            }
        }

        sayGoodbye();
    }

    private static void checkInput(Value value, State state, List<StateInputCheck> checks) {
        checks.stream().filter(check -> check.isValidFor(state)).forEach(check -> check.check(value));
    }

    private static Value getIntegerInput(Scanner scanner) {
        try {
            return Value.of(scanner.nextLong());
        } catch (InputMismatchException e) {
            throw new NaturalNumberException("Natural number expected", e);
        }
    }

    private static String askRequest(Scanner scanner) {
        System.out.print("\nEnter a request: ");
        return scanner.nextLine();
    }

    private static void welcomeUsers() {
        System.out.println("Welcome to Amazing Numbers!");
    }

    private static void printInstructions() {
        INSTRUCTIONS.forEach(System.out::println);
    }

    private static void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}
