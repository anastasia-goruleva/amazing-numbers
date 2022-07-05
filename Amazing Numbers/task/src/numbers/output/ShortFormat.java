package numbers.output;

import numbers.properties.Property;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortFormat implements OutputFormat {
    @Override
    public void display(long number) {
        System.out.printf("%s is %s\n", number,
                Stream.of(Property.ALL)
                        .filter(p -> p.check(number))
                        .map(Property::toString)
                        .collect(Collectors.joining(", "))
                        .toLowerCase());
    }
}
