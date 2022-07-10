package numbers.inputchecks;

import numbers.states.State;

import java.util.Set;

public abstract class StateInputCheck implements InputCheck {
    private final Set<Class<? extends State>> states;

    protected StateInputCheck(Set<Class<? extends State>> states) {
        this.states = states;
    }

    public boolean isValidFor(State state) {
        return states.contains(state.getClass());
    }
}
