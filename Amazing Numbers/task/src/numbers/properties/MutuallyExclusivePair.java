package numbers.properties;

import java.util.Arrays;
import java.util.Collection;

public class MutuallyExclusivePair {
    private final String[] pair;
    private final boolean fully;

    private MutuallyExclusivePair(String first, String second, boolean fully) {
        this.pair = new String[] { first, second };
        this.fully = fully;
    }

    public boolean areElementsOf(Collection<String> properties) {
        return properties.contains(pair[0]) && properties.contains(pair[1]);
    }

    public boolean isFully() {
        return fully;
    }

    public String getNegationString() {
        return String.format("[-%s, -%s]", pair[0], pair[1]);
    }

    @Override
    public String toString() {
        return Arrays.toString(pair);
    }

    public static MutuallyExclusivePair of(Property first, Property second, boolean fully) {
        return new MutuallyExclusivePair(first.toString(), second.toString(), fully);
    }
}
