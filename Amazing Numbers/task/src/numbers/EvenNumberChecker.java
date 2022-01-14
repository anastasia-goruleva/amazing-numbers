package numbers;

public class EvenNumberChecker extends ParityChecker {
    public EvenNumberChecker() {
        super(PropertyType.EVEN);
    }

    @Override
    protected int arrayIndex(boolean yes) {
        return 1 - booleanToInt(yes);
    }

    @Override
    public boolean test(String s) {
        return !isOdd(s);
    }
}
