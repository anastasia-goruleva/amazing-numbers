package numbers;

public class NumberProperty {
    private final String number;
    private final boolean isPresent;
    private final String answer;

    public NumberProperty(String number, boolean isPresent, String answer) {
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
        System.out.println(getAnswer());
    }
}
