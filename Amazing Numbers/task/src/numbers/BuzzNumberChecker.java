package numbers;

public class BuzzNumberChecker implements PropertyChecker {
    private static final int MAGIC_NUMBER = 7;
    private static final int DECIMAL_BASE = 10;

    @Override
    public boolean test(String s) {
        final var number = Long.parseLong(s);
        final var endsWith = number % DECIMAL_BASE == MAGIC_NUMBER;
        final var divisibleBy = number % MAGIC_NUMBER == 0;
        return endsWith || divisibleBy;
    }
}
