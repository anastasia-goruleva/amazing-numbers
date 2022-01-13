package numbers;

import java.util.function.Predicate;

public abstract class ErrorChecker implements Predicate<String> {
    private final String message;

    public ErrorChecker(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }

    public final void throwException(String number) {
        if (!test(number)) {
            throw new IllegalArgumentException(message);
        }
    }
}
