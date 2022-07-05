package numbers.inputchecks;

import numbers.exceptions.NaturalNumberException;

import static numbers.ValueContainer.Value;

public class NaturalNumberCheck implements InputCheck {
    @Override
    public void check(Value value) {
        if (value.<Long>get() < 1L) {
            throw new NaturalNumberException();
        }
    }
}
