package numbers.common;

import java.util.Scanner;
import java.util.function.Function;

import static numbers.common.ValueContainer.Value;

public interface InputProvider extends Function<Scanner, Value> {
}
