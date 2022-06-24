package numbers;

public class EvenNumberChecker extends ParityChecker {
    @Override
    public boolean test(String s) {
        return !isOdd(s);
    }
}
