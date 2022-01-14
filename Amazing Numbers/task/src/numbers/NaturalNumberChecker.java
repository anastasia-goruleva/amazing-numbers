package numbers;

public class NaturalNumberChecker extends ErrorChecker {
    private static final String NATURAL_NUMBER_PATTERN = "0*[1-9]\\d*";

    public NaturalNumberChecker() {
        super("The first parameter should be a natural number or zero.");
    }

    @Override
    public boolean test(String s) {
        return s.matches(NATURAL_NUMBER_PATTERN);
    }
}
