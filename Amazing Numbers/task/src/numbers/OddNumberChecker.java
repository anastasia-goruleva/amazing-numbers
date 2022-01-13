package numbers;

public class OddNumberChecker extends ParityChecker {
    public OddNumberChecker() {
        super(PropertyType.ODD);
    }

    @Override
    protected NumberProperty createNumberProperty(String s, boolean odd, String answer) {
        return new NumberProperty(s, odd, answer);
    }
}
