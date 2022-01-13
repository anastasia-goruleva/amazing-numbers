package numbers;

import java.util.function.Predicate;

public abstract class ParityChecker extends NumberPropertyChecker {
    private static final String[] ANSWERS = { "Even", "Odd" };
    private static final String ODD_DIGITS = "13579";

    public ParityChecker(PropertyType type) {
        super("This number is %s.", type);
    }

    protected boolean isOdd(String s) {
        return ODD_DIGITS.indexOf(s.charAt(s.length() - 1)) != NOT_FOUND;
    }

    @Override
    public NumberProperty apply(String s) {
        final var yes = isOdd(s);
        final var answerIndex = yes ? 1 : 0;
        return createNumberProperty(s, yes, formAnswer(ANSWERS[answerIndex]));
    }

    protected abstract NumberProperty createNumberProperty(String s, boolean yes, String answer);
}