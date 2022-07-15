package numbers.states;

import numbers.exceptions.UnexpectedInputException;
import numbers.output.OutputFormat;
import numbers.properties.Property;

import java.util.Collection;
import java.util.stream.Collectors;

import static numbers.common.ValueContainer.Value;

public class PropertySearchState implements State {
    final Range range;
    final Collection<Property> properties;

    public PropertySearchState(Range range, Collection<String> properties) {
        this.range = range;
        this.properties = properties.stream().map(Property::valueOf).collect(Collectors.toList());
    }

    @Override
    public State getNextState(Value value) {
        throw new UnexpectedInputException();
    }

    @Override
    public void processData(OutputFormat numberOutput) {
        range.getLimitedStream(range.createStream().filter(v -> properties.stream().allMatch(p -> p.check(v))))
                .forEach(numberOutput);
    }
}
