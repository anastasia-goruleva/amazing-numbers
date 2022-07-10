package numbers.states;

import numbers.common.Range;
import numbers.output.OutputFormat;

import static numbers.common.ValueContainer.Value;

public class SingleState implements State {
    private final long number;

    public SingleState(long number) {
        this.number = number;
    }

    @Override
    public State getNextState(Value value) {
        return new RangeState(new Range(number, value.get()));
    }

    @Override
    public void processData(OutputFormat outputFormat) {
        outputFormat.accept(number);
    }
}
