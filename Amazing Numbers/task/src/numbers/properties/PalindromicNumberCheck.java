package numbers.properties;

import java.util.stream.IntStream;

public class PalindromicNumberCheck implements PropertyCheck {
    @Override
    public boolean check(long number) {
        final var s = String.valueOf(number);
        return IntStream.range(0, s.length() / 2).allMatch(i -> s.charAt(i) == s.charAt(s.length() - 1 - i));
    }
}
