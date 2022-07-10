package numbers.common;

import java.util.function.Supplier;

public class ValueContainer {
    public interface Value {
        <T> T get();

        static <T> Value of(T value) {
            return new ValueStorage<T>(value);
        }
    }

    private static class ValueStorage <T> implements Value {
        private T value;

        public ValueStorage(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return value;
        }
    }
}
