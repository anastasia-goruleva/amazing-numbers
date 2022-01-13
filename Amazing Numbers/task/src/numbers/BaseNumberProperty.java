package numbers;

public class BaseNumberProperty {
    private final int number;
    private final boolean isPresent;
    private final String answer;

    public BaseNumberProperty(int number, boolean isPresent, String answer) {
        this.number = number;
        this.isPresent = isPresent;
        this.answer = answer;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public String getAnswer() {
        return answer;
    }

    public void print() {
    }
}
