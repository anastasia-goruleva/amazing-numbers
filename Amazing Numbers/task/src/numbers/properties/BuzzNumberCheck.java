package numbers.properties;

public class BuzzNumberCheck implements PropertyCheck {
    private static final int MAGIC_NUMBER = 7;
    private static final int DECIMAL_BASE = 10;

    @Override
    public boolean check(long number) {
        final var endsWith = number % DECIMAL_BASE == MAGIC_NUMBER;
        final var divisibleBy = number % MAGIC_NUMBER == 0;
        return endsWith || divisibleBy;
    }
}
