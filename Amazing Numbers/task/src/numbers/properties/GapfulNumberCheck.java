package numbers.properties;

public class GapfulNumberCheck implements PropertyCheck {
    private static final int MINIMAL_LENGTH = 3;

    @Override
    public boolean test(String s) {
        return s.length() >= MINIMAL_LENGTH
                && Long.parseLong(s) % Long.parseLong(String.format("%c%c", s.charAt(0), s.charAt(s.length() - 1))) == 0;
    }
}
