package numbers.inputchecks;

import numbers.exceptions.MutuallyExclusivePropertiesException;
import numbers.properties.InputPropertySet;
import numbers.properties.MutuallyExclusiveLocation;
import numbers.properties.MutuallyExclusivePair;
import numbers.properties.Property;
import numbers.states.RangeState;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static numbers.common.ValueContainer.Value;

public class MutuallyExclusivePropertiesCheck extends StateInputCheck {
    private static final List<MutuallyExclusivePair> propertyPairs = List.of(
            MutuallyExclusivePair.of(Property.EVEN, Property.ODD, true),
            MutuallyExclusivePair.of(Property.DUCK, Property.SPY, false),
            MutuallyExclusivePair.of(Property.SUNNY, Property.SQUARE, false),
            MutuallyExclusivePair.of(Property.HAPPY, Property.SAD, true)
    );

    public MutuallyExclusivePropertiesCheck() {
        super(Set.of(RangeState.class));
    }

    @Override
    public void check(Value value) {
        final var inputProperties = value.<InputPropertySet>get();
        final var foundProperties = propertyPairs
                .stream()
                .flatMap(inputProperties::getMutuallyExclusionStream)
                .map(MutuallyExclusiveLocation::toString)
                .collect(Collectors.toList());
        if (!foundProperties.isEmpty()) {
            throw new MutuallyExclusivePropertiesException(foundProperties);
        }
    }
}
