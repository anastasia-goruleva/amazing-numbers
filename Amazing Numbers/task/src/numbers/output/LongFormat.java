package numbers.output;

import numbers.properties.Property;

import java.util.stream.Stream;

public class LongFormat implements OutputFormat {
    private static final int ADDITIONAL_SPACE = 4;
    private static final int PROPERTY_FIELD_MAX_LENGTH = getPropertyFieldMaxLength() + ADDITIONAL_SPACE;
    private static final String PROPERTY_OUTPUT_FORMAT = String.format("%%%ds: %%b\n", PROPERTY_FIELD_MAX_LENGTH);

    private static int getPropertyFieldMaxLength() {
        return Stream.of(Property.ALL).mapToInt(type -> type.toString().length()).max().orElse(0);
    }

    @Override
    public void display(String number) {
        System.out.println("Properties of " + number);
        Stream.of(Property.ALL).forEach(p -> print(p, number));
    }

    private void print(Property property, String number) {
        System.out.printf(PROPERTY_OUTPUT_FORMAT,
                property.toString().toLowerCase(),
                property.getChecker().test(number));
    }
}
