package numbers.properties;

public class PerfectSquareCheck {
    public static boolean isPerfectSquare(long n) {
        final var lastDigit = n % PropertyCheck.DECIMAL_BASE;

        if (lastDigit == 2 || lastDigit == 3 || lastDigit == 7 || lastDigit == 8) {
            return false;
        }

        final var squareRoot = (long) Math.sqrt(n);

        return squareRoot * squareRoot == n;
    }
}
