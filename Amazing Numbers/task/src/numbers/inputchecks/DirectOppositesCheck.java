package numbers.inputchecks;

import numbers.exceptions.MutuallyExclusivePropertiesException;
import numbers.properties.InputPropertySet;
import numbers.properties.Property;
import numbers.states.RangeState;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static numbers.common.ValueContainer.Value;

public class DirectOppositesCheck extends StateInputCheck {
    public DirectOppositesCheck() {
        super(Set.of(RangeState.class));
    }

    @Override
    public void check(Value value) {
        final var inputProperties = value.<InputPropertySet>get();
        final var opposites = Stream.of(Property.ALL)
                .filter(p -> inputProperties.hasOpposites(p.toString()))
                .map(p -> String.format("[%1$s, -%1$s]", p))
                .collect(Collectors.toList());
        if (!opposites.isEmpty()) {
            throw new MutuallyExclusivePropertiesException(opposites);
        }
    }
}
