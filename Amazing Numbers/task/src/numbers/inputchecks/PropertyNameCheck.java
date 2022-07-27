package numbers.inputchecks;

import numbers.exceptions.WrongPropertyNameException;
import numbers.properties.InputPropertySet;
import numbers.properties.Property;
import numbers.states.RangeState;

import java.util.Set;
import java.util.stream.Collectors;

import static numbers.common.ValueContainer.Value;

public class PropertyNameCheck extends StateInputCheck {
    public PropertyNameCheck() {
        super(Set.of(RangeState.class));
    }

    @Override
    public void check(Value value) {
        final var inputProperties = value.<InputPropertySet>get();
        final var wrongNames = inputProperties
                .allPropertyNamesStream()
                .filter(n -> !Property.exists(n))
                .collect(Collectors.toSet());
        if (!wrongNames.isEmpty()) {
            throw new WrongPropertyNameException(wrongNames);
        }
    }
}
