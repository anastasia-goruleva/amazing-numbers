package numbers.inputchecks;

import numbers.exceptions.NaturalNumberException;
import numbers.states.InitialState;
import numbers.states.SingleState;

import java.util.Set;

import static numbers.common.ValueContainer.Value;

public class NaturalNumberCheck extends StateInputCheck {
    public NaturalNumberCheck() {
        super(Set.of(InitialState.class, SingleState.class));
    }

    @Override
    public void check(Value value) {
        if (value.<Long>get() < 1L) {
            throw new NaturalNumberException();
        }
    }
}
