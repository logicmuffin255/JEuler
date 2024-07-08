package name.benshepley.euler.problems.set1;

import name.benshepley.euler.framework.Solvable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*  Problem 1: https://projecteuler.net/problem=1
    Multiples of 3 and 5
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class TestProblem1 {
    @Test
    public void evaluateProblem() {
        final String ANSWER = "233168";
        Solvable problem = new Problem1();
        assertEquals(ANSWER, problem.getSolution());
    }
}
