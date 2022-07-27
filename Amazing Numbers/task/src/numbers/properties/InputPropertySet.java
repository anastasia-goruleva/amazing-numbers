package numbers.properties;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputPropertySet {
    private final Set<String> presented;
    private final Set<String> excluded;

    public InputPropertySet(Set<String> presented, Set<String> excluded) {
        this.presented = presented;
        this.excluded = excluded;
    }

    public Stream<String> allPropertyNamesStream() {
        return Stream.concat(presented.stream(), excluded.stream());
    }

    public Set<Property> getPresented() {
        return mapToPropertySet(presented);
    }

    public Set<Property> getExcluded() {
        return mapToPropertySet(excluded);
    }

    public boolean hasOpposites(String name) {
        return presented.contains(name) && excluded.contains(name);
    }

    public Stream<MutuallyExclusiveLocation> getMutuallyExclusionStream(MutuallyExclusivePair pair) {
        var locationStream = Stream.<MutuallyExclusiveLocation>empty();
        if (pair.areElementsOf(presented)) {
            locationStream = Stream.concat(locationStream,
                    Stream.of(MutuallyExclusiveLocation.of(pair, true)));
        }

        if (pair.isFully() && pair.areElementsOf(excluded)) {
            locationStream = Stream.concat(locationStream,
                    Stream.of(MutuallyExclusiveLocation.of(pair, false)));
        }

        return locationStream;
    }

    private static Set<Property> mapToPropertySet(Set<String> propertyStrings) {
        return propertyStrings.stream().map(Property::valueOf).collect(Collectors.toSet());
    }
}
