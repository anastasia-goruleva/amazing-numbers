package numbers.properties;

public class SpyNumberCheck implements PropertyCheck {
    @Override
    public boolean check(long number) {
        var sum = 0L;
        var product = 1L;
        for (; number > 0; number /= DECIMAL_BASE) {
            final var digit = number % DECIMAL_BASE;
            sum += digit;
            product *= digit;
        }

        return sum == product;
    }
}
