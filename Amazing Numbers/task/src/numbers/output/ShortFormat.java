package numbers.output;

import numbers.properties.Property;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortFormat implements OutputFormat {
    @Override
    public void display(String number) {
        System.out.printf("%s is %s\n", number,
                Stream.of(Property.ALL)
                        .filter(p -> p.getChecker().test(number))
                        .map(Property::toString)
                        .collect(Collectors.joining(", "))
                        .toLowerCase());
    }
}
