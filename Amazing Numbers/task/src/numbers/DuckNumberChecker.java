package numbers;

public class DuckNumberChecker extends NumberPropertyChecker {
    private static final char ZERO_CHARACTER = '0';
    private static final String PREFIX = String.format("^%c+", ZERO_CHARACTER);

    public DuckNumberChecker() {
        super(PropertyType.DUCK);
    }

    @Override
    public boolean test(String s) {
        return s.replaceFirst(PREFIX, "").indexOf(ZERO_CHARACTER) != NOT_FOUND;
    }
}
