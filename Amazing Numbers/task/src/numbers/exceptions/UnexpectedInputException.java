package numbers.exceptions;

public class UnexpectedInputException extends RuntimeException {
    public UnexpectedInputException() {
        super("Unexpected user input");
    }
}
