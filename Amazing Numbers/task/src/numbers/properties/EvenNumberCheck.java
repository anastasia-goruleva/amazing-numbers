package numbers.properties;

public class EvenNumberCheck extends ParityCheck {
    @Override
    public boolean check(long number) {
        return !isOdd(number);
    }
}
