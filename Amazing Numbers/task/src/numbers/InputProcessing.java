package numbers;

import static numbers.common.ValueContainer.Value;

import numbers.exceptions.NaturalNumberException;
import numbers.inputchecks.ExitRequestCheck;
import numbers.inputchecks.NaturalNumberCheck;
import numbers.inputchecks.StateInputCheck;
import numbers.output.LongFormat;
import numbers.output.OutputFormat;
import numbers.output.ShortFormat;
import numbers.states.InitialState;
import numbers.states.RangeState;
import numbers.states.SingleState;
import numbers.states.State;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputProcessing {
    private static final List<StateInputCheck> INPUT_CHECKS = List.of(
            new ExitRequestCheck(),
            new NaturalNumberCheck()
    );

    private static final Map<Class<? extends State>, String> ERROR_MESSAGES = Map.of(
            InitialState.class, "The first parameter should be a natural number or zero.",
            SingleState.class, "The second parameter should be a natural number."
    );

    private static final Map<Class<? extends State>, OutputFormat> NUMBER_FORMATS = Map.of(
            SingleState.class, new LongFormat(),
            RangeState.class, new ShortFormat()
    );

    private final Scanner scanner;
    private State state;

    public InputProcessing(Scanner scanner) {
        this.scanner = scanner;
        this.state = new InitialState();
    }

    public void process() {
        while (scanner.hasNext()) {
            // read data
            final var value = getIntegerInput();
            // check input
            checkInput(value);
            // go to next state
            state = state.getNextState(value);
        }

        state.processData(NUMBER_FORMATS.get(state.getClass()));
    }

    private void checkInput(Value value) {
        try {
            INPUT_CHECKS.stream().filter(check -> check.isValidFor(state)).forEach(check -> check.check(value));
        } catch (NaturalNumberException e) {
            throw new NaturalNumberException(ERROR_MESSAGES.get(state.getClass()), e);
        }
    }

    private Value getIntegerInput() {
        try {
            return Value.of(scanner.nextLong());
        } catch (InputMismatchException e) {
            throw new NaturalNumberException(ERROR_MESSAGES.get(state.getClass()), e);
        }
    }
}
