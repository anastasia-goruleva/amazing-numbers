package numbers.states;
import static numbers.common.ValueContainer.Value;

public interface State {
    State getNextState(Value value);
    void processData();
}
