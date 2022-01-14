package numbers;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class NumberPropertyChecker implements Predicate<String>, Function<String, NumberProperty>,
        Consumer<String> {
    protected static final String NEGATIVE = "not ";
    protected static final int NOT_FOUND = -1;
    private static final int ADDITIONAL_SPACE = 4;
    private static final int PROPERTY_FIELD_MAX_LENGTH = getPropertyFieldMaxLength() + ADDITIONAL_SPACE;
    private static final String PROPERTY_OUTPUT_FORMAT = String.format("%%%ds: %%b\n", PROPERTY_FIELD_MAX_LENGTH);
    private static final String COMMON_ANSWER_FORMAT = "It is %%sa %s number.";

    private static int getPropertyFieldMaxLength() {
        return Stream.of(PropertyType.values()).mapToInt(type -> type.toString().length()).max().orElse(0);
    }

    private static String getCapitalized(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    protected static String formAnswer(String format, String argument) {
        return String.format(format, argument);
    }

    private final String answerFormat;
    private final PropertyType type;

    public NumberPropertyChecker(PropertyType type) {
        this(formAnswer(COMMON_ANSWER_FORMAT, getCapitalized(type.toString())), type);
    }

    public NumberPropertyChecker(String answerFormat, PropertyType type) {
        this.answerFormat = answerFormat;
        this.type = type;
    }

    public String formAnswer(String s) {
        return formAnswer(answerFormat, s);
    }

    public void print(NumberProperty property) {
        System.out.printf(PROPERTY_OUTPUT_FORMAT, type.toString().toLowerCase(), property.isPresent());
    }

    @Override
    public NumberProperty apply(String s) {
        final var yes = test(s);
        return new NumberProperty(s, yes, formAnswer(yes));
    }

    protected String formAnswer(boolean yes) {
        return formAnswer(yes ? "" : NEGATIVE);
    }

    @Override
    public void accept(String s) {
        print(apply(s));
    }
}
