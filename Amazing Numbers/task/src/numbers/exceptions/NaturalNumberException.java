package numbers.exceptions;

public class NaturalNumberException extends RuntimeException {
    public NaturalNumberException() {
    }

    public NaturalNumberException(String message) {
        super(message);
    }

    public NaturalNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
