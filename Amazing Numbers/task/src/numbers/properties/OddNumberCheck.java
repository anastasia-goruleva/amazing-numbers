package numbers.properties;

public class OddNumberCheck extends ParityCheck {
    @Override
    public boolean test(String s) {
        return isOdd(s);
    }
}
