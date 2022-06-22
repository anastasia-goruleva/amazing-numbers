package numbers;

public class OddNumberChecker extends ParityChecker {
    public OddNumberChecker() {
        super(PropertyType.ODD);
    }

    @Override
    public boolean test(String s) {
        return isOdd(s);
    }
}
