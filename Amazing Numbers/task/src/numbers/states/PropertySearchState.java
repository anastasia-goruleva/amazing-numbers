package numbers.states;

import numbers.exceptions.UnexpectedInputException;
import numbers.output.OutputFormat;
import numbers.properties.InputPropertySet;
import numbers.properties.Property;

import java.util.Collection;

import static numbers.common.ValueContainer.Value;

public class PropertySearchState implements State {
    private final Range range;
    private final Collection<Property> presented;
    private final Collection<Property> excluded;

    public PropertySearchState(Range range, InputPropertySet inputProperties) {
        this.range = range;
        this.presented = inputProperties.getPresented();
        this.excluded = inputProperties.getExcluded();
    }

    @Override
    public State getNextState(Value value) {
        throw new UnexpectedInputException();
    }

    @Override
    public void processData(OutputFormat numberOutput) {
        range.getLimitedStream(range.createStream().filter(this::checkValue))
                .forEach(numberOutput);
    }

    private boolean checkValue(long value) {
        return presented.stream().allMatch(p -> p.check(value))
                && excluded.stream().noneMatch(p -> p.check(value));
    }
}
