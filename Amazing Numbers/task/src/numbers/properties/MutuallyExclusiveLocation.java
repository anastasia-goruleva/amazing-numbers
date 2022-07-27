package numbers.properties;

public class MutuallyExclusiveLocation {
    private final MutuallyExclusivePair pair;
    private final boolean isPresented;

    private MutuallyExclusiveLocation(MutuallyExclusivePair pair, boolean isPresented) {
        this.pair = pair;
        this.isPresented = isPresented;
    }

    @Override
    public String toString() {
        return isPresented ? pair.toString() : pair.getNegationString();
    }

    public static MutuallyExclusiveLocation of(MutuallyExclusivePair pair, boolean isPresented) {
        return new MutuallyExclusiveLocation(pair, isPresented);
    }
}
