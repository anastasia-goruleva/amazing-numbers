package numbers;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var errorCheckers = List.of(new NaturalNumberChecker());

        final var propertyCheckers = List.of(
                new ParityChecker(),
                new BuzzNumberChecker(),
                new DuckNumberChecker());

        final var number = askNumber(new Scanner(System.in));
        try {
            errorCheckers.forEach(checker -> checker.throwException(number));
            propertyCheckers.forEach(checker -> checker.apply(number).print());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static String askNumber(Scanner scanner) {
        System.out.println("Enter a natural number:");
        return scanner.next();
    }
}
