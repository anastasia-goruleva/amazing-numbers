package numbers;

public abstract class ParityChecker implements PropertyChecker {
    private static final String ODD_DIGITS = "13579";

    protected boolean isOdd(String s) {
        return ODD_DIGITS.indexOf(s.charAt(s.length() - 1)) != NOT_FOUND;
    }
}