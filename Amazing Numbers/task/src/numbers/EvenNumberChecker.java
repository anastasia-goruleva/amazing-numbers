package numbers;

public class EvenNumberChecker extends ParityChecker {
    public EvenNumberChecker() {
        super(PropertyType.EVEN);
    }

    @Override
    protected NumberProperty createNumberProperty(String s, boolean odd, String answer) {
        return new NumberProperty(s, !odd, answer);
    }
}
