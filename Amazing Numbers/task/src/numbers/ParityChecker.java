package numbers;

public class ParityChecker extends NumberPropertyChecker {
    private static final String[] ANSWERS = { "Even", "Odd" };
    private static final String ODD_DIGITS = "13579";
    private static final int NOT_FOUND = -1;

    public ParityChecker() {
        super("This number is %s.");
    }

    @Override
    public NumberProperty apply(String s) {
        final var isOdd = ODD_DIGITS.indexOf(s.charAt(s.length() - 1)) != NOT_FOUND;
        final var answerIndex = isOdd ? 1 : 0;
        return new NumberProperty(s, isOdd, formAnswer(ANSWERS[answerIndex]));
    }
}