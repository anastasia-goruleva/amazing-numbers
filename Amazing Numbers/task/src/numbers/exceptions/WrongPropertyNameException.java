package numbers.exceptions;

public class WrongPropertyNameException extends RuntimeException {
    public WrongPropertyNameException(String message) {
        super(message);
    }
}
