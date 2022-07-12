package numbers.properties;

public class SpyNumberCheck implements PropertyCheck {
    private static final int BASE = 10;

    @Override
    public boolean check(long number) {
        var sum = 0L;
        var product = 1L;
        for (; number > 0; number /= BASE) {
            final var digit = number % BASE;
            sum += digit;
            product *= digit;
        }

        return sum == product;
    }
}
