package name.benshepley.euler.problems.set1;

import name.benshepley.euler.framework.Solvable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*  Problem 3: https://projecteuler.net/problem=3
    Largest prime factor
    The prime factors of 13195 are 5, 7, 13 and 29.
    What is the largest prime factor of the number 600851475143 ?
 */
public class TestProblem3 {
    @Test
    public void evaluateProblem_3() {
        final String ANSWER = "6857";
        Solvable problem = new Problem3();
        assertEquals(ANSWER, problem.getSolution());
    }
}
