package numbers;

import java.util.function.Function;

public abstract class NumberPropertyChecker implements Function<String, NumberProperty> {
    protected static final String NEGATIVE = "not ";

    private final String answerFormat;

    public NumberPropertyChecker(String answerFormat) {
        this.answerFormat = answerFormat;
    }

    public String formAnswer(String s) {
        return String.format(answerFormat, s);
    }
}
