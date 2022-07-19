package numbers.inputchecks;

import numbers.exceptions.MutuallyExclusivePropertiesException;
import numbers.properties.MutuallyExclusivePair;
import numbers.properties.Property;
import numbers.states.RangeState;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static numbers.common.ValueContainer.Value;

public class MutuallyExclusivePropertiesCheck extends StateInputCheck {
    private static final List<MutuallyExclusivePair> propertyPairs = List.of(
            MutuallyExclusivePair.of(Property.EVEN, Property.ODD),
            MutuallyExclusivePair.of(Property.DUCK, Property.SPY),
            MutuallyExclusivePair.of(Property.SUNNY, Property.SQUARE),
            MutuallyExclusivePair.of(Property.HAPPY, Property.SAD)
    );

    public MutuallyExclusivePropertiesCheck() {
        super(Set.of(RangeState.class));
    }

    @Override
    public void check(Value value) {
        final var foundProperties =
                propertyPairs.stream().filter(p -> p.areElementsOf(value.get())).collect(Collectors.toList());
        if (!foundProperties.isEmpty()) {
            throw new MutuallyExclusivePropertiesException(foundProperties);
        }
    }
}
