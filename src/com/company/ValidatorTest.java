package com.company;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a + b - c", "a+b", "a+b/c", "(a+b)*c", "-a", "a", "((a - b) * (a + b) - c) / d"})
    public void testValidCases(String s) {
        Validator validator = new Validator(s);
        assertTrue(validator.isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {"MM-xx", "a/", "$b$", "*a", "ab", "a-", "(a + b ", "(a + b))"})
    public void testInvalidCases(String s) {
        Validator validator = new Validator(s);
        assertFalse(validator.isValid());
    }
}