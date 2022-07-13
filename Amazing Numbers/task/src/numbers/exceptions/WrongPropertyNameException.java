package numbers.exceptions;

import numbers.properties.Property;

import java.util.Arrays;
import java.util.List;

public class WrongPropertyNameException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "The property %s is wrong.\nAvailable properties: %s";

    public WrongPropertyNameException(String text) {
        super(formMessage(text));
    }

    private static String formMessage(String text) {
        return String.format(MESSAGE_FORMAT, List.of(text.toUpperCase()), Arrays.toString(Property.ALL));
    }
}
