package numbers;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class NumberPropertyChecker implements Function<String, NumberProperty>, Consumer<String> {
    protected static final String NEGATIVE = "not ";
    protected static final int NOT_FOUND = -1;

    protected static String formAnswer(String format, String argument) {
        return String.format(format, argument);
    }

    private final String answerFormat;
    private final PropertyType type;

    public NumberPropertyChecker(String answerFormat, PropertyType type) {
        this.answerFormat = answerFormat;
        this.type = type;
    }

    public String formAnswer(String s) {
        return formAnswer(answerFormat, s);
    }

    public void print(NumberProperty property) {
        System.out.printf("\t%s: %b\n", type.toString().toLowerCase(), property.isPresent());
    }

    @Override
    public void accept(String s) {
        print(apply(s));
    }
}
