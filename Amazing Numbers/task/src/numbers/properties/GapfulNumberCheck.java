package numbers.properties;

public class GapfulNumberCheck implements PropertyCheck {
    private static final int MINIMAL_LENGTH = 3;

    @Override
    public boolean check(long number) {
        final var s = String.valueOf(number);
        final var digitConcatenation = Long.parseLong(String.format("%c%c", s.charAt(0), s.charAt(s.length() - 1)));
        return s.length() >= MINIMAL_LENGTH && number % digitConcatenation == 0;
    }
}
