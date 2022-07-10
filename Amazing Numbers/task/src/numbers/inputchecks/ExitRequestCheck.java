package numbers.inputchecks;

import numbers.exceptions.ExitRequestException;
import numbers.states.InitialState;

import java.util.Set;

import static numbers.common.ValueContainer.Value;

public class ExitRequestCheck extends StateInputCheck {
    public ExitRequestCheck() {
        super(Set.of(InitialState.class));
    }

    @Override
    public void check(Value value) {
        if (value.<Long>get() == 0L) {
            throw new ExitRequestException();
        }
    }
}
