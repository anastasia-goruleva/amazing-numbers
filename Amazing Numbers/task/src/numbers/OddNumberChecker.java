package numbers;

public class OddNumberChecker extends ParityChecker {
    @Override
    public boolean test(String s) {
        return isOdd(s);
    }
}
