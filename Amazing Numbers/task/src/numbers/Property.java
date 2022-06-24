package numbers;

public enum Property {
    EVEN(new EvenNumberChecker()),
    ODD(new OddNumberChecker()),
    BUZZ(new BuzzNumberChecker()),
    DUCK(new DuckNumberChecker()),
    PALINDROMIC(new PalindromicNumberChecker()),
    GAPFUL(new GapfulNumberChecker());

    public static final Property[] ALL = values();

    private final PropertyChecker checker;

    Property(PropertyChecker checker) {
        this.checker = checker;
    }

    public PropertyChecker getChecker() {
        return checker;
    }
}
