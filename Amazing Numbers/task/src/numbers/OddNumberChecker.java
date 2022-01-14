package numbers;

public class OddNumberChecker extends ParityChecker {
    public OddNumberChecker() {
        super(PropertyType.ODD);
    }

    @Override
    protected int arrayIndex(boolean yes) {
        return booleanToInt(yes);
    }

    @Override
    public boolean test(String s) {
        return isOdd(s);
    }
}
