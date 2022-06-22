package numbers;

import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class NumberPropertyChecker implements Predicate<String> {
    protected static final int NOT_FOUND = -1;
    private static final int ADDITIONAL_SPACE = 4;
    private static final int PROPERTY_FIELD_MAX_LENGTH = getPropertyFieldMaxLength() + ADDITIONAL_SPACE;
    private static final String PROPERTY_OUTPUT_FORMAT = String.format("%%%ds: %%b\n", PROPERTY_FIELD_MAX_LENGTH);

    private static int getPropertyFieldMaxLength() {
        return Stream.of(PropertyType.values()).mapToInt(type -> type.toString().length()).max().orElse(0);
    }

    private final PropertyType type;

    public NumberPropertyChecker(PropertyType type) {
        this.type = type;
    }

    public void print(String s) {
        System.out.printf(PROPERTY_OUTPUT_FORMAT, type.toString().toLowerCase(), test(s));
    }

}
