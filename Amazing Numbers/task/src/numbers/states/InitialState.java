package numbers.states;

import numbers.exceptions.NoUserInputException;

import static numbers.common.ValueContainer.Value;

public class InitialState implements State {
    @Override
    public State getNextState(Value value) {
        return null;
    }

    @Override
    public void processData() {
        throw new NoUserInputException();
    }
}
