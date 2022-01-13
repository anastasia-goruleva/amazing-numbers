package numbers;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var checkers = List.of(
                new NaturalNumberChecker(),
                new ParityChecker(),
                new BuzzNumberChecker());

        final var number = askNumber(new Scanner(System.in));
        try {
            for (final var checker : checkers) {
                final var property = checker.checkProperty(number);
                if (checker.isMandatory() && !property.isPresent()) {
                    throw new IllegalArgumentException(property.getAnswer());
                }
                property.print();
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static int askNumber(Scanner scanner) {
        System.out.println("Enter a natural number:");
        return scanner.nextInt();
    }
}
