package numbers.properties;

public class JumpingNumberCheck implements PropertyCheck {
    @Override
    public boolean check(long number) {
        final var s = String.valueOf(number);
        for (var i = 1; i < s.length(); ++i) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != 1) {
                return false;
            }
        }
        return true;
    }
}
