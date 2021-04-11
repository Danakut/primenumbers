package com.example.primenumbers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumbersIdentifierTest {

    private NumbersIdentifier numbersIdentifier;

    @BeforeEach
    private void init() {
        numbersIdentifier = new NumbersIdentifier();
    }

    @ParameterizedTest
    @ValueSource(strings = {"58", "+58", "0085"})
    void isPositiveIntegerShouldReturnTrueForValidStrings(String value) {
        boolean isPositiveInteger = numbersIdentifier.isPositiveInteger(value);

        assertTrue(isPositiveInteger);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-58", "++58", "-/*87", " 854"})
    void isPositiveIntegerShouldReturnFalseForInvalidStrings(String value) {
        boolean isPositiveInteger = numbersIdentifier.isPositiveInteger(value);

        assertFalse(isPositiveInteger);
    }

    @ParameterizedTest
    @ValueSource(longs = {3L, 800010833L})
    void isPrimeNumberShouldReturnTrueForPrimes(long number) {
        boolean isPrime = numbersIdentifier.isPrimeNumber(number);

        assertTrue(isPrime);
    }

    @ParameterizedTest
    @ValueSource(longs = {6L, 800022751L})
    void isPrimeNumberShouldReturnFalseForNonPrimes(long number) {
        boolean isPrime = numbersIdentifier.isPrimeNumber(number);

        assertFalse(isPrime);
    }

    @Test
    void isPrimeNumberShouldThrowExceptionForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> numbersIdentifier.isPrimeNumber(-58L));
    }

    @Test
    void isPrimeNumberShouldThrowExceptionForZero() {
        assertThrows(IllegalArgumentException.class, () -> numbersIdentifier.isPrimeNumber(0L));
    }
}