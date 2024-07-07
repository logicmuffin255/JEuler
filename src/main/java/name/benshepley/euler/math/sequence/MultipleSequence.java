package name.benshepley.euler.math.sequence;

import name.benshepley.euler.framework.sequence.SequenceStream;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class MultipleSequence implements SequenceStream {
	private final long start;
	private final long multiple;

	public MultipleSequence(MultipleSequenceBuilder multipleSequenceBuilder) {
		this.start = multipleSequenceBuilder.start;
		this.multiple = multipleSequenceBuilder.multiple;
	}

	public static final class MultipleSequenceBuilder {
		private long start = 0;
		private long multiple = 0;

		public MultipleSequenceBuilder setMultiple(long multiple) {
			this.multiple = multiple;
			return this;
		}

		public MultipleSequenceBuilder setStart(long start) {
			this.start = start;
			return this;
		}

		public MultipleSequence build() {
			return new MultipleSequence(this);
		}
	}

	public LongStream generate() {
		return LongStream.generate(new LongSupplier() {
			long amount = MultipleSequence.this.start;
		    public long getAsLong() {
		    	amount += multiple;
		    	return amount;
		    }
		});
	}
}