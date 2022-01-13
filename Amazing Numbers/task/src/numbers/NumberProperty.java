package numbers;

public class NumberProperty extends BaseNumberProperty {
    public NumberProperty(int number, boolean isPresent, String answer) {
        super(number, isPresent, answer);
    }

    public void print() {
        System.out.println(getAnswer());
    }
}
