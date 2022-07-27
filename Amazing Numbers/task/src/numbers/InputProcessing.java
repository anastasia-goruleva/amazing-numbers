package numbers;

import numbers.common.InputProvider;
import numbers.exceptions.InputErrorException;
import numbers.exceptions.NaturalNumberException;
import numbers.inputchecks.*;
import numbers.output.LongFormat;
import numbers.output.OutputFormat;
import numbers.output.ShortFormat;
import numbers.properties.InputPropertySet;
import numbers.states.*;

import java.util.*;

import static numbers.common.ValueContainer.Value;

public class InputProcessing {
    private static final List<StateInputCheck> INPUT_CHECKS = List.of(
            new ExitRequestCheck(),
            new NaturalNumberCheck(),
            new PropertyNameCheck(),
            new DirectOppositesCheck(),
            new MutuallyExclusivePropertiesCheck()
    );

    private static final Map<Class<? extends State>, String> ERROR_MESSAGES = Map.of(
            InitialState.class, "The first parameter should be a natural number or zero.",
            SingleState.class, "The second parameter should be a natural number."
    );

    private static final OutputFormat RANGE_OUTPUT_FORMAT = new ShortFormat();

    private static final Map<Class<? extends State>, OutputFormat> NUMBER_FORMATS = Map.of(
            SingleState.class, new LongFormat(),
            RangeState.class, RANGE_OUTPUT_FORMAT,
            PropertySearchState.class, RANGE_OUTPUT_FORMAT
    );

    private static final Map<Class<? extends State>, InputProvider> INPUT_PROVIDERS = Map.of(
            InitialState.class, InputProcessing::getIntegerInput,
            SingleState.class, InputProcessing::getIntegerInput,
            RangeState.class, InputProcessing::getProperties
    );

    private static final char EXCLUDE_SIGN = '-';

    private final Scanner scanner;
    private State state;

    public InputProcessing(Scanner scanner) {
        this.scanner = scanner;
        this.state = new InitialState();
    }

    public void process() {
        try {
            while (scanner.hasNext()) {
                // read data
                final var value = getInput();
                // check input
                checkInput(value);
                // go to next state
                state = state.getNextState(value);
            }

            state.processData(NUMBER_FORMATS.get(state.getClass()));
        } catch (NaturalNumberException e) {
            throwInputError(ERROR_MESSAGES.get(state.getClass()), e);
        }
    }

    private void checkInput(Value value) {
        INPUT_CHECKS.stream().filter(check -> check.isValidFor(state)).forEach(check -> check.check(value));
    }

    private void throwInputError(String message, RuntimeException e) {
        throw new InputErrorException(message, e);
    }

    private Value getInput() {
        return INPUT_PROVIDERS.get(state.getClass()).apply(scanner);
    }

    private static Value getIntegerInput(Scanner scanner) {
        try {
            return Value.of(scanner.nextLong());
        } catch (InputMismatchException e) {
            throw new NaturalNumberException(e);
        }
    }

    private static Value getProperties(Scanner scanner) {
        final var presented = new HashSet<String>();
        final var excluded = new HashSet<String>();
        scanner.tokens().forEach(s -> {
            if (s.charAt(0) == EXCLUDE_SIGN) {
                excluded.add(s.substring(1));
            } else {
                presented.add(s);
            }
        });
        return Value.of(new InputPropertySet(presented, excluded));
    }
}
