package numbers.exceptions;

import numbers.properties.MutuallyExclusivePair;

import java.util.Collection;
import java.util.stream.Collectors;

public class MutuallyExclusivePropertiesException extends RuntimeException {
    private static final String MESSAGE_FORMAT =
            "The request contains mutually exclusive properties: %s\n" +
            "There are no numbers with these properties.";

    public MutuallyExclusivePropertiesException(Collection<MutuallyExclusivePair> propertyPairs) {
        super(formMessage(propertyPairs));
    }

    private static String formMessage(Collection<MutuallyExclusivePair> propertyPairs) {
        return String.format(MESSAGE_FORMAT, toString(propertyPairs));
    }

    private static String toString(Collection<MutuallyExclusivePair> propertyPairs) {
        return propertyPairs.stream().map(MutuallyExclusivePair::toString).collect(Collectors.joining(", "));
    }
}
