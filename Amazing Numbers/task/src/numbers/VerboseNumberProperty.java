package numbers;

public class VerboseNumberProperty extends NumberProperty {
    private final String explanation;

    public VerboseNumberProperty(String number, boolean isPresent, String answer, String explanation) {
        super(number, isPresent, answer);
        this.explanation = explanation;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Explanation:");
        System.out.println(explanation);
    }
}
