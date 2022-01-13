package numbers;

public class ParityChecker extends NumberPropertyChecker {
    private static final String[] answers = { "Even", "Odd" };
    private static final String answerText = "This number is %s.";

    public ParityChecker() {
        super(false);
    }

    @Override
    public NumberProperty checkProperty(int n) {
        final var isOdd = (n & 1) == 1;
        final var answerIndex = isOdd ? 1 : 0;
        return new NumberProperty(n, isOdd,
                String.format(answerText, answers[answerIndex]));
    }
}