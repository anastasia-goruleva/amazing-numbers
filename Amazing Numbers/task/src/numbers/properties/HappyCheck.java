package numbers.properties;

import java.util.HashSet;

public class HappyCheck {
    public static boolean isHappyNumber(long number) {
        final var numberRepeat = new HashSet<Long>();
        while (number != 1L && !numberRepeat.contains(number)) {
            numberRepeat.add(number);
            number = squaredDigitSum(number);
        }

        return number == 1L;
    }

    private static long squaredDigitSum(long number) {
        var sum = 0L;

        for (; number != 0; number /= PropertyCheck.DECIMAL_BASE) {
            final var digit = number % PropertyCheck.DECIMAL_BASE;
            sum += digit * digit;
        }

        return sum;
    }
}
