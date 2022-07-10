package numbers.states;
import numbers.output.OutputFormat;

import static numbers.common.ValueContainer.Value;

public interface State {
    State getNextState(Value value);
    void processData(OutputFormat numberOutput);
}
