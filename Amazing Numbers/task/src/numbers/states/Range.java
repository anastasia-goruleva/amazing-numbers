package numbers.states;

import java.util.stream.LongStream;

public class Range {
    private final long start;
    private final long count;

    public long getStart() {
        return start;
    }

    public long getCount() {
        return count;
    }

    public Range(long start, long count) {
        this.start = start;
        this.count = count;
    }

    public LongStream createStream() {
        return LongStream.iterate(start, v -> ++v);
    }

    public LongStream getLimitedStream(LongStream stream) {
        return stream.limit(count);
    }
}
