package numbers.properties;

public enum Property {
    EVEN(new EvenNumberCheck()),
    ODD(new OddNumberCheck()),
    BUZZ(new BuzzNumberCheck()),
    DUCK(new DuckNumberCheck()),
    PALINDROMIC(new PalindromicNumberCheck()),
    GAPFUL(new GapfulNumberCheck());

    public static final Property[] ALL = values();

    private final PropertyCheck propertyCheck;

    Property(PropertyCheck propertyCheck) {
        this.propertyCheck = propertyCheck;
    }

    public boolean check(long number) {
        return propertyCheck.check(number);
    }
}
