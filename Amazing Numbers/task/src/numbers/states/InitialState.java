package numbers.states;

import numbers.exceptions.NoUserInputException;
import numbers.output.OutputFormat;

import static numbers.common.ValueContainer.Value;

public class InitialState implements State {
    @Override
    public State getNextState(Value value) {
        return new SingleState(value.get());
    }

    @Override
    public void processData(OutputFormat outputFormat) {
        throw new NoUserInputException();
    }
}
