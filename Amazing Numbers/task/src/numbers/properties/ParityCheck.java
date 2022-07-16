package numbers.properties;

public class ParityCheck {
    public static boolean isOdd(long number) {
        return (number & 1) == 1;
    }
}