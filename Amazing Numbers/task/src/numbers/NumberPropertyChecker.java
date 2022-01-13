package numbers;

public abstract class NumberPropertyChecker {
    private final boolean mandatory;

    public NumberPropertyChecker(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public abstract BaseNumberProperty checkProperty(int n);
}
