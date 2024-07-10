package name.benshepley.euler.problems.set1;

import name.benshepley.euler.framework.Solvable;
import name.benshepley.euler.math.function.PrimeFunction;

/*  Problem 3: https://projecteuler.net/problem=3
    Largest prime factor
    The prime factors of 13195 are 5, 7, 13 and 29.
    What is the largest prime factor of the number 600851475143 ?

	SEE TestProblem_3 FOR SOLUTION.
 */
public class Problem3 implements Solvable {

	@Override
	public String getSolution() {
		long max = PrimeFunction.getPrimeFactors(600_851_475_143L).stream().max(Long::compareTo).get();
		return Long.toString(max);
	}

}
