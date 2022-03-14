package com.visualnuts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class Exercise1Test {
    @Test
    void exceptionWithNullArgument() {
        assertThrows(IllegalArgumentException.class, () -> Exercise1.main(new String[]{null}));
    }

    @Test
    void exceptionWithDoubleArgument() {
        assertThrows(IllegalArgumentException.class, () -> Exercise1.main(new String[]{"0.42"}));
    }

    @Test
    void exceptionWithStringArgument() {
        assertThrows(IllegalArgumentException.class, () -> Exercise1.main(new String[]{"abc"}));
    }

    @Test
    void exceptionWithNegativeNumberArgument() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Exercise1.main(new String[] { "0" }));
        assertEquals("0 not allowed.", e.getMessage());
    }

    @Test
    void testPositive() {
        Exercise1.main(new String[] { "500" });
    }

    @Test
    void testNegative() {
        Exercise1.main(new String[] { "-500" });
    }
}