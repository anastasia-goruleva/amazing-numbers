package numbers.properties;

public enum Property {
    EVEN(new EvenNumberCheck()),
    ODD(new OddNumberCheck()),
    BUZZ(new BuzzNumberCheck()),
    DUCK(new DuckNumberCheck()),
    PALINDROMIC(new PalindromicNumberCheck()),
    GAPFUL(new GapfulNumberCheck());

    public static final Property[] ALL = values();

    private final PropertyCheck checker;

    Property(PropertyCheck checker) {
        this.checker = checker;
    }

    public PropertyCheck getChecker() {
        return checker;
    }
}
