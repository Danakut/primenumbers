package com.example.primenumbers;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class NumbersIdentifier {

    public static final Pattern PATTERN = Pattern.compile("[+]??\\d++");
    public static final int[] primesTo100 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    /*Valid inputs: Only digit characteds allowed. No more than one "+" sign can be present at the beginning of the
    number. Any number of leading zeroes is allowed.*/
    public boolean isPositiveInteger(String value) {
        if (value == null) {
            return false;
        }

        return PATTERN.matcher(value).matches();
    }

    public boolean isPrimeNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("'number' should be a positive integer.");
        }

        if (isPrimeUnder100(number)) {
            return true;
        } else if (number < 101) {
            return false;
        } else {
            return isPrimeOver100(number);
        }
    }

    private boolean isPrimeUnder100(long number) {
        return IntStream.of(primesTo100)
                .anyMatch(prime -> prime == number);
    }

    private boolean isPrimeOver100(long number) {
        double sqrt = Math.sqrt(number);
        long divisorLimit = (long) sqrt;

        return !isDivisibleByPrimesTo100(number, divisorLimit) && !isDivisible(number, divisorLimit);
    }

    private boolean isDivisibleByPrimesTo100(long number, long divisorLimit) {
        int index = 0;
        int primeAsDivisor = primesTo100[index];

        while (primeAsDivisor <= divisorLimit) {
            if (number % primeAsDivisor == 0) {
                return true;
            } else if (index == primesTo100.length - 1) {
                break;
            } else {
                index++;
                primeAsDivisor = primesTo100[index];
            }
        }

        return false;
    }

    //isDivisible = is divisible by a number other than 1 and itself
    private boolean isDivisible(long number, long divisorLimit) {
        long divisor = 101;

        while (divisor <= divisorLimit) {
            if (number % divisor == 0) {
                return true;
            } else {
                divisor += 2;
            }
        }

        return false;
    }
}
