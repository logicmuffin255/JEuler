package name.benshepley.euler.math.function;

import name.benshepley.euler.math.sequence.PrimeSequence;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.LongStream;

public class PrimeFunction {
    /**
     * Generate Prime Factors for a given number.
     * @param number to get prime factors for.
     * @return prime factors in a Set of longs.
     */
    public static List<Long> getPrimeFactors(long number) {
        PrimeSequence primeSequence = new PrimeSequence();
        List<Long> primeFactors = new LinkedList<>();

        long squareRootOfNumber = (long) Math.sqrt((double)number) + 1L;
        LongStream primeStream = primeSequence.generate().takeWhile(prime -> prime <= squareRootOfNumber);
        primeStream.forEach(prime -> {
            if (number % prime == 0) {
                primeFactors.add(prime);
            }
        });

        return primeFactors;
    }

    public static class IsPrime implements Predicate<Long> {
        @Override
        public boolean test(Long number) {
            return LongStream.rangeClosed(2, number/2L).noneMatch(i -> number%i == 0);
        }
    }
}
