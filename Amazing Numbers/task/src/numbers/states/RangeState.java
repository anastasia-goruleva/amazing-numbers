package numbers.states;

import numbers.common.Range;
import numbers.output.OutputFormat;

import static numbers.common.ValueContainer.Value;

public class RangeState implements State {
    private final Range range;

    public RangeState(Range range) {
        this.range = range;
    }

    @Override
    public State getNextState(Value value) {
        return new PropertySearchState(range, value.get());
    }

    @Override
    public void processData(OutputFormat numberOutput) {
        range.getLimitedStream(range.createStream()).forEach(numberOutput);
    }
}
