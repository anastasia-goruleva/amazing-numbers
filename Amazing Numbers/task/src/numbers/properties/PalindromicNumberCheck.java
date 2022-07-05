package numbers.properties;

import java.util.stream.IntStream;

public class PalindromicNumberCheck implements PropertyCheck {
    @Override
    public boolean test(String s) {
        return IntStream.range(0, s.length() / 2).allMatch(i -> s.charAt(i) == s.charAt(s.length() - 1 - i));
    }
}
