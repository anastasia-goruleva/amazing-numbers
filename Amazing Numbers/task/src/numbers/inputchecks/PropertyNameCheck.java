package numbers.inputchecks;

import static numbers.common.ValueContainer.Value;

import numbers.exceptions.WrongPropertyNameException;
import numbers.properties.Property;
import numbers.states.RangeState;

import java.util.Set;

public class PropertyNameCheck extends StateInputCheck {
    public PropertyNameCheck() {
        super(Set.of(RangeState.class));
    }

    @Override
    public void check(Value value) {
        final String propertyName = value.get();
        if (!Property.exists(propertyName)) {
            throw new WrongPropertyNameException(propertyName);
        }
    }
}
