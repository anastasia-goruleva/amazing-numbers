package numbers.properties;

import java.util.Arrays;
import java.util.Collection;

public class MutuallyExclusivePair {
    private final String[] pair;

    private MutuallyExclusivePair(String first, String second) {
        pair = new String[] { first, second };
    }

    public static MutuallyExclusivePair of(Property first, Property second) {
        return new MutuallyExclusivePair(first.toString(), second.toString());
    }

    public boolean areElementsOf(Collection<String> properties) {
        return properties.contains(pair[0]) && properties.contains(pair[1]);
    }

    @Override
    public String toString() {
        return Arrays.toString(pair);
    }
}
