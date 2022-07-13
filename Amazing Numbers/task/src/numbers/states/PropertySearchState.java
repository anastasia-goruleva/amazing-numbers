package numbers.states;

import numbers.common.Range;
import numbers.exceptions.UnexpectedInputException;
import numbers.output.OutputFormat;
import numbers.properties.Property;

import static numbers.common.ValueContainer.Value;

public class PropertySearchState implements State {
    final Range range;
    final Property property;

    public PropertySearchState(Range range, String propertyName) {
        this.range = range;
        this.property = Property.valueOf(propertyName.toUpperCase());
    }

    @Override
    public State getNextState(Value value) {
        throw new UnexpectedInputException();
    }

    @Override
    public void processData(OutputFormat numberOutput) {
        range.getLimitedStream(range.createStream().filter(property::check))
                .forEach(numberOutput);
    }
}
