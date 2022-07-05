package numbers.properties;

public abstract class ParityCheck implements PropertyCheck {
    protected boolean isOdd(long number) {
        return (number & 1) == 1;
    }
}