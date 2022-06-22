package numbers;

public abstract class ParityChecker extends NumberPropertyChecker {
    private static final String ODD_DIGITS = "13579";

    protected ParityChecker(PropertyType type) {
        super(type);
    }

    protected boolean isOdd(String s) {
        return ODD_DIGITS.indexOf(s.charAt(s.length() - 1)) != NOT_FOUND;
    }
}