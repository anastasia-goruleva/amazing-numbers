package numbers.properties;

import java.util.stream.Stream;

public enum Property {
    EVEN(new EvenNumberCheck()),
    ODD(new OddNumberCheck()),
    BUZZ(new BuzzNumberCheck()),
    DUCK(new DuckNumberCheck()),
    PALINDROMIC(new PalindromicNumberCheck()),
    GAPFUL(new GapfulNumberCheck()),
    SPY(new SpyNumberCheck()),
    SUNNY(new SunnyNumberCheck()),
    SQUARE(new SquareNumberCheck());

    public static final Property[] ALL = values();

    private final PropertyCheck propertyCheck;

    Property(PropertyCheck propertyCheck) {
        this.propertyCheck = propertyCheck;
    }

    public boolean check(long number) {
        return propertyCheck.check(number);
    }

    public static boolean exists(String propertyName) {
        return Stream.of(ALL).map(Property::toString).anyMatch(propertyName::equalsIgnoreCase);
    }
}
