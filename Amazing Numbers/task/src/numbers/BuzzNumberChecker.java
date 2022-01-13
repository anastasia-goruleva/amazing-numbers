package numbers;

public class BuzzNumberChecker extends NumberPropertyChecker {
    private static final int MAGIC_NUMBER = 7;
    private static final int DECIMAL_BASE = 10;
    private static final String answer = "It is %sa Buzz number.";
    private static final String negative = "not ";

    private enum Explanations {
        NOT_BUZZ("is neither divisible by %1$d nor does it end with %1$d."),
        DIVISIBLE_BY("is divisible by %1$d."),
        ENDS_WITH("ends with %1$d."),
        DIVISIBLE_AND_ENDS("is divisible by %1$d and ends with %1$d.");

        private static final String numberPlaceholder = "%d ";
        private final String explanation;

        Explanations(String explanation) {
            this.explanation = explanation;
        }

        public String getFullExplanation(int n) {
            return String.format(numberPlaceholder.concat(String.format(explanation, MAGIC_NUMBER)), n);
        }
    }

    public BuzzNumberChecker() {
        super(false);
    }

    @Override
    public BaseNumberProperty checkProperty(int n) {
        final var endsWith = n % DECIMAL_BASE == MAGIC_NUMBER;
        final var divisibleBy = n % MAGIC_NUMBER == 0;
        final var isBuzz = endsWith || divisibleBy;

        var explanation = Explanations.NOT_BUZZ;
        if (endsWith && divisibleBy) {
            explanation = Explanations.DIVISIBLE_AND_ENDS;
        } else if (endsWith) {
            explanation = Explanations.ENDS_WITH;
        } else if (divisibleBy) {
            explanation = Explanations.DIVISIBLE_BY;
        }

        return new VerboseNumberProperty(n, isBuzz, String.format(answer, isBuzz ? "" : negative),
                explanation.getFullExplanation(n));
    }
}
