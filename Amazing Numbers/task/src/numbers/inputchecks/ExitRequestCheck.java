package numbers.inputchecks;

import numbers.exceptions.ExitRequestException;

import static numbers.ValueContainer.Value;

public class ExitRequestCheck implements InputCheck {
    @Override
    public void check(Value value) {
        if (value.<Long>get() == 0L) {
            throw new ExitRequestException();
        }
    }
}
