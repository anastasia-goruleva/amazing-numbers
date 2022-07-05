package numbers.properties;

public class DuckNumberCheck implements PropertyCheck {
    private static final int NOT_FOUND = -1;
    private static final char ZERO_CHARACTER = '0';

    @Override
    public boolean check(long number) {
        final var s = String.valueOf(number);
        return s.indexOf(ZERO_CHARACTER) != NOT_FOUND;
    }
}
