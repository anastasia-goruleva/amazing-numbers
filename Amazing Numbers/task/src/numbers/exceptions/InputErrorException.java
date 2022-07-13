package numbers.exceptions;

public class InputErrorException extends RuntimeException {
    public InputErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
