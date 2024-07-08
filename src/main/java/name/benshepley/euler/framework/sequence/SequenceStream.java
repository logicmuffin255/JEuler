package name.benshepley.euler.framework.sequence;

import java.util.stream.LongStream;

public interface SequenceStream {
    LongStream generate();
}