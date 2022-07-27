package numbers.exceptions;

import java.util.Collection;

public class MutuallyExclusivePropertiesException extends RuntimeException {
    private static final String MESSAGE_FORMAT =
            "The request contains mutually exclusive properties: %s\n" +
                    "There are no numbers with these properties.";

    public MutuallyExclusivePropertiesException(Collection<String> propertyPairs) {
        super(formMessage(propertyPairs));
    }

    private static String formMessage(Collection<String> propertyPairs) {
        return String.format(MESSAGE_FORMAT, String.join(", ", propertyPairs));
    }
}
