package numbers;

public class NaturalNumberChecker extends NumberPropertyChecker {
    private static final String answerText = "This number is %snatural!";
    public NaturalNumberChecker() {
        super(true);
    }

    @Override
    public BaseNumberProperty checkProperty(int n) {
        final var isNatural = n > 0;
        return new BaseNumberProperty(n, isNatural,
                String.format(answerText, isNatural ? "" : "not "));
    }
}
