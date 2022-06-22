package numbers;

public class EvenNumberChecker extends ParityChecker {
    public EvenNumberChecker() {
        super(PropertyType.EVEN);
    }

    @Override
    public boolean test(String s) {
        return !isOdd(s);
    }
}
