package numbers.properties;

import java.util.function.Predicate;

public interface PropertyCheck extends Predicate<String> {
    int NOT_FOUND = -1;
}
