package numbers.inputchecks;

import numbers.State;

import java.util.Set;

public class StateInputCheck {
    private final Set<Class<State>> states;
    private final InputCheck check;

    private StateInputCheck(Set<Class<State>> states, InputCheck check) {
        this.states = states;
        this.check = check;
    }

    public Set<Class<State>> getStates() {
        return states;
    }

    public InputCheck getCheck() {
        return check;
    }

    public boolean isValidFor(State state) {
        return states.contains(state.getClass());
    }

    public static StateInputCheck of(Set<Class<State>> states, InputCheck checker) {
        return new StateInputCheck(states, checker);
    }
}
