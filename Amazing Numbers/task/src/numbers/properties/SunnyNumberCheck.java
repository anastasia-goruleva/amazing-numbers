package numbers.properties;

public class SunnyNumberCheck implements PropertyCheck {
    @Override
    public boolean check(long number) {
        return PerfectSquareCheck.isPerfectSquare(number + 1);
    }
}
