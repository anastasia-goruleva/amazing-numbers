package numbers.properties;

public class OddNumberCheck implements PropertyCheck {
    @Override
    public boolean check(long number) {
        return ParityCheck.isOdd(number);
    }
}
