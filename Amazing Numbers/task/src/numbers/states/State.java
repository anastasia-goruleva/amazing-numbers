package numbers.states;
import static numbers.ValueContainer.Value;

public interface State {
    State getNextState(Value value);
    void processData();
}
