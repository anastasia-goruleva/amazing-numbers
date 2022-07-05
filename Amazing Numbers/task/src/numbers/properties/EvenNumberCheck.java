package numbers.properties;

public class EvenNumberCheck extends ParityCheck {
    @Override
    public boolean test(String s) {
        return !isOdd(s);
    }
}
