package numbers;

public abstract class ParityChecker extends NumberPropertyChecker {
    private static final String[] ANSWERS = {"Even", "Odd"};
    private static final String ODD_DIGITS = "13579";

    protected static int booleanToInt(boolean yes) {
        return yes ? 1 : 0;
    }

    public ParityChecker(PropertyType type) {
        super("This number is %s.", type);
    }

    protected boolean isOdd(String s) {
        return ODD_DIGITS.indexOf(s.charAt(s.length() - 1)) != NOT_FOUND;
    }

    @Override
    protected String formAnswer(boolean yes) {
        return formAnswer(ANSWERS[arrayIndex(yes)]);
    }

    protected abstract int arrayIndex(boolean yes);
}