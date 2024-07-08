package name.benshepley.euler.math.sequence;

import name.benshepley.euler.framework.sequence.SequenceStream;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class FibonacciSequence implements SequenceStream {
	public LongStream generate() {
		return LongStream.generate(new LongSupplier() {
		    long a = 1, b = 2;

		    public long getAsLong() {
		        long result = a;
		        a = b;
		        b = a + result;
		        return result;
		    }
		});
	}
}
