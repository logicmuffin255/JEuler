package name.benshepley.euler.problems.set1;

import name.benshepley.euler.framework.Solvable;
import name.benshepley.euler.math.sequence.MultipleSequence;

import java.util.stream.LongStream;

/*  Problem 1: https://projecteuler.net/problem=1
    Multiples of 3 and 5
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.

    NOTE: SEE TestProblem_1 FOR SOLUTION.
 */

public class Problem_1 implements Solvable {
	
	public String getSolution() {
		MultipleSequence threeGenerator = new MultipleSequence.MultipleSequenceBuilder()
				.setMultiple(3)
				.setStart(0)
				.build();
		
		MultipleSequence fiveGenerator = new MultipleSequence.MultipleSequenceBuilder()
				.setMultiple(5)
				.setStart(0)
				.build();
		
		LongStream threeStream = threeGenerator
				.generate()
				.takeWhile(i -> i < 1000);
		
		LongStream fiveStream = fiveGenerator
				.generate()
				.takeWhile(i -> i < 1000);
		
		long solution = LongStream.concat(threeStream, fiveStream).sorted().distinct().sum();
		return Long.toString(solution);
	}
}