package numbers;

import java.util.function.Predicate;

public interface PropertyChecker extends Predicate<String> {
    int NOT_FOUND = -1;
}
