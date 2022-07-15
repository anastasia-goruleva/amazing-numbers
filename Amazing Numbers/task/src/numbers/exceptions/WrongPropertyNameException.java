package numbers.exceptions;

import numbers.properties.Property;

import java.util.Arrays;
import java.util.Collection;

public class WrongPropertyNameException extends RuntimeException {
    private static final String[] VERB_FORMS = {"is", "are"};
    private static final String[] ENDINGS = { "y", "ies" };
    private static final String MESSAGE_FORMAT = "The propert%s %s %s wrong.\nAvailable properties: %s";

    public WrongPropertyNameException(Collection<String> wrongNames) {
        super(formMessage(wrongNames));
    }

    private static String formMessage(Collection<String> wrongNames) {
        final var formIndex = wrongNames.size() > 1 ? 1 : 0;
        return String.format(MESSAGE_FORMAT, ENDINGS[formIndex], wrongNames, VERB_FORMS[formIndex],
                Arrays.toString(Property.ALL));
    }
}
