package numbers.properties;

public class HappyNumberCheck implements PropertyCheck {
    @Override
    public boolean check(long number) {
        return HappyCheck.isHappyNumber(number);
    }
}
