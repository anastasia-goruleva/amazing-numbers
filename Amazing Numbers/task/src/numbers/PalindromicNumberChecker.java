package numbers;

import java.util.stream.IntStream;

public class PalindromicNumberChecker extends NumberPropertyChecker {
    public PalindromicNumberChecker() {
        super(PropertyType.PALINDROMIC);
    }

    @Override
    public boolean test(String s) {
        return IntStream.range(0, s.length() / 2).allMatch(i -> s.charAt(i) == s.charAt(s.length() - 1 - i));
    }
}
