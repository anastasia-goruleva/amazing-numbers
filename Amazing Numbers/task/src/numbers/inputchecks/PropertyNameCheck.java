package numbers.inputchecks;

import static numbers.common.ValueContainer.Value;

import numbers.exceptions.WrongPropertyNameException;
import numbers.properties.Property;
import numbers.states.RangeState;

import java.util.Set;
import java.util.stream.Collectors;

public class PropertyNameCheck extends StateInputCheck {
    public PropertyNameCheck() {
        super(Set.of(RangeState.class));
    }

    @Override
    public void check(Value value) {
        final var propertyNames = value.<Set<String>>get();
        final var wrongNames = propertyNames.stream()
                .filter(n -> !Property.exists(n))
                .collect(Collectors.toList());
        if (!wrongNames.isEmpty()) {
            throw new WrongPropertyNameException(wrongNames);
        }
    }
}
