package numbers.properties;

public class OddNumberCheck extends ParityCheck {
    @Override
    public boolean check(long number) {
        return isOdd(number);
    }
}
