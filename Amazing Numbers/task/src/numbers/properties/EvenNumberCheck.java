package numbers.properties;

public class EvenNumberCheck implements PropertyCheck {
    @Override
    public boolean check(long number) {
        return !ParityCheck.isOdd(number);
    }
}
