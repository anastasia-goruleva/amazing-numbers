package numbers.properties;

public class DuckNumberCheck implements PropertyCheck {
    private static final char ZERO_CHARACTER = '0';
    private static final String PREFIX = String.format("^%c+", ZERO_CHARACTER);

    @Override
    public boolean test(String s) {
        return s.replaceFirst(PREFIX, "").indexOf(ZERO_CHARACTER) != NOT_FOUND;
    }
}