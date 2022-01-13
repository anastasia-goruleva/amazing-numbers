package numbers;

public class DuckNumberChecker extends NumberPropertyChecker {
    private static final char ZERO_CHARACTER = '0';
    private static final String PREFIX = String.format("^%c+", ZERO_CHARACTER);

    public DuckNumberChecker() {
        super("It is %sa Duck number.", PropertyType.DUCK);
    }

    @Override
    public NumberProperty apply(String s) {
        final var isDuck = s.replaceFirst(PREFIX, "").indexOf(ZERO_CHARACTER) != NOT_FOUND;
        return new NumberProperty(s, isDuck, formAnswer(isDuck ? "" : NEGATIVE));
    }
}
