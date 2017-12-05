/*
 * Copyright 2017 Thomas Rix (thomasrix@exodus-project.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.marandus.argval.validator;

import com.github.marandus.argval.enums.NumberCompareOperator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 */
public class NumberArgumentValidatorImplTest {

    public NumberArgumentValidatorImplTest() {
    }

    @Test
    public void testRequireValue_byte_EQUAL_42_42() {
        byte test = 42;

        this.testCompare42(test, NumberCompareOperator.EQUAL, false);
    }

    @Test
    public void testRequireValue_byte_EQUAL_42_41() {
        byte test = 41;

        this.testCompare42(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireValue_byte_EQUAL_42_43() {
        byte test = 43;

        this.testCompare42(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireValue_byte_GREATER_42_42() {
        byte test = 42;

        this.testCompare42(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireValue_byte_GREATER_42_41() {
        byte test = 41;

        this.testCompare42(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireValue_byte_GREATER_42_43() {
        byte test = 43;

        this.testCompare42(test, NumberCompareOperator.GREATER, false);
    }

    @Test
    public void testRequireValue_byte_GREATER_EQUAL_42_42() {
        byte test = 42;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireValue_byte_GREATER_EQUAL_42_41() {
        byte test = 41;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, true);
    }

    @Test
    public void testRequireValue_byte_GREATER_EQUAL_42_43() {
        byte test = 43;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireValue_byte_LESS_42_42() {
        byte test = 42;

        this.testCompare42(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireValue_byte_LESS_42_41() {
        byte test = 41;

        this.testCompare42(test, NumberCompareOperator.LESS, false);
    }

    @Test
    public void testRequireValue_byte_LESS_42_43() {
        byte test = 43;

        this.testCompare42(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireValue_byte_LESS_EQUAL_42_42() {
        byte test = 42;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireValue_byte_LESS_EQUAL_42_41() {
        byte test = 41;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireValue_byte_LESS_EQUAL_42_43() {
        byte test = 43;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, true);
    }

    @Test
    public void testRequireValue_short_EQUAL_42_42() {
        short test = 42;

        this.testCompare42(test, NumberCompareOperator.EQUAL, false);
    }

    @Test
    public void testRequireValue_short_EQUAL_42_41() {
        short test = 41;

        this.testCompare42(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireValue_short_EQUAL_42_43() {
        short test = 43;

        this.testCompare42(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireValue_short_GREATER_42_42() {
        short test = 42;

        this.testCompare42(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireValue_short_GREATER_42_41() {
        short test = 41;

        this.testCompare42(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireValue_short_GREATER_42_43() {
        short test = 43;

        this.testCompare42(test, NumberCompareOperator.GREATER, false);
    }

    @Test
    public void testRequireValue_short_GREATER_EQUAL_42_42() {
        short test = 42;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireValue_short_GREATER_EQUAL_42_41() {
        short test = 41;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, true);
    }

    @Test
    public void testRequireValue_short_GREATER_EQUAL_42_43() {
        short test = 43;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireValue_short_LESS_42_42() {
        short test = 42;

        this.testCompare42(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireValue_short_LESS_42_41() {
        short test = 41;

        this.testCompare42(test, NumberCompareOperator.LESS, false);
    }

    @Test
    public void testRequireValue_short_LESS_42_43() {
        short test = 43;

        this.testCompare42(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireValue_short_LESS_EQUAL_42_42() {
        short test = 42;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireValue_short_LESS_EQUAL_42_41() {
        short test = 41;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireValue_short_LESS_EQUAL_42_43() {
        short test = 43;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, true);
    }

    @Test
    public void testRequireValue_int_EQUAL_42_42() {
        int test = 42;

        this.testCompare42(test, NumberCompareOperator.EQUAL, false);
    }

    @Test
    public void testRequireValue_int_EQUAL_42_41() {
        int test = 41;

        this.testCompare42(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireValue_int_EQUAL_42_43() {
        int test = 43;

        this.testCompare42(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireValue_int_GREATER_42_42() {
        int test = 42;

        this.testCompare42(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireValue_int_GREATER_42_41() {
        int test = 41;

        this.testCompare42(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireValue_int_GREATER_42_43() {
        int test = 43;

        this.testCompare42(test, NumberCompareOperator.GREATER, false);
    }

    @Test
    public void testRequireValue_int_GREATER_EQUAL_42_42() {
        int test = 42;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireValue_int_GREATER_EQUAL_42_41() {
        int test = 41;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, true);
    }

    @Test
    public void testRequireValue_int_GREATER_EQUAL_42_43() {
        int test = 43;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireValue_int_LESS_42_42() {
        int test = 42;

        this.testCompare42(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireValue_int_LESS_42_41() {
        int test = 41;

        this.testCompare42(test, NumberCompareOperator.LESS, false);
    }

    @Test
    public void testRequireValue_int_LESS_42_43() {
        int test = 43;

        this.testCompare42(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireValue_int_LESS_EQUAL_42_42() {
        int test = 42;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireValue_int_LESS_EQUAL_42_41() {
        int test = 41;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireValue_int_LESS_EQUAL_42_43() {
        int test = 43;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, true);
    }

    @Test
    public void testRequireValue_long_EQUAL_42_42() {
        long test = 42;

        this.testCompare42(test, NumberCompareOperator.EQUAL, false);
    }

    @Test
    public void testRequireValue_long_EQUAL_42_41() {
        long test = 41;

        this.testCompare42(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireValue_long_EQUAL_42_43() {
        long test = 43;

        this.testCompare42(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireValue_long_GREATER_42_42() {
        long test = 42;

        this.testCompare42(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireValue_long_GREATER_42_41() {
        long test = 41;

        this.testCompare42(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireValue_long_GREATER_42_43() {
        long test = 43;

        this.testCompare42(test, NumberCompareOperator.GREATER, false);
    }

    @Test
    public void testRequireValue_long_GREATER_EQUAL_42_42() {
        long test = 42;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireValue_long_GREATER_EQUAL_42_41() {
        long test = 41;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, true);
    }

    @Test
    public void testRequireValue_long_GREATER_EQUAL_42_43() {
        long test = 43;

        this.testCompare42(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireValue_long_LESS_42_42() {
        long test = 42;

        this.testCompare42(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireValue_long_LESS_42_41() {
        long test = 41;

        this.testCompare42(test, NumberCompareOperator.LESS, false);
    }

    @Test
    public void testRequireValue_long_LESS_42_43() {
        long test = 43;

        this.testCompare42(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireValue_long_LESS_EQUAL_42_42() {
        long test = 42;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireValue_long_LESS_EQUAL_42_41() {
        long test = 41;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireValue_long_LESS_EQUAL_42_43() {
        long test = 43;

        this.testCompare42(test, NumberCompareOperator.LESS_EQUAL, true);
    }

    @Test
    public void testRequireNegative_neg1() {
        final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
        instance.requireNegative(-1L, "Some message");
    }

    @Test
    public void testRequireNegative_0() {
        try {
            final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
            instance.requireNegative(0L, "Some message");

            fail();
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Value is not negative (Some message): 0", ex.getMessage());
        }
    }

    @Test
    public void testRequireNegative_pos1() {
        try {
            final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
            instance.requireNegative(1L, "Some message");

            fail();
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Value is not negative (Some message): 1", ex.getMessage());
        }
    }

    @Test
    public void testRequirePositive_neg1() {
        try {
            final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
            instance.requirePositive(-1L, "Some message");

            fail();
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Value is not positive (Some message): -1", ex.getMessage());
        }
    }

    @Test
    public void testRequirePositive_0() {
        try {
            final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
            instance.requirePositive(0L, "Some message");

            fail();
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Value is not positive (Some message): 0", ex.getMessage());
        }
    }

    @Test
    public void testRequirePositive_pos1() {
        final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
        instance.requirePositive(1L, "Some message");
    }

    @Test
    public void testRequireZero_neg1() {
        try {
            final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
            instance.requireZero(-1L, "Some message");

            fail();
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Value is not zero (Some message): -1", ex.getMessage());
        }
    }

    @Test
    public void testRequireZero_0() {
        final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
        instance.requireZero(0L, "Some message");
    }

    @Test
    public void testRequireZero_pos1() {
        try {
            final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
            instance.requireZero(1L, "Some message");

            fail();
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Value is not zero (Some message): 1", ex.getMessage());
        }
    }

    private void testCompare42(final byte test, final NumberCompareOperator comp, final boolean doFail) {
        try {
            final byte exp = 42;

            final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
            instance.requireValue(test, exp, comp, "Some message");

            if (doFail) {
                fail();
            }
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Byte value violation (Some message): byte(" + test + ") " + comp.getOperator() + " 42", ex.getMessage());
        }
    }

    private void testCompare42(final short test, final NumberCompareOperator comp, final boolean doFail) {
        try {
            final short exp = 42;

            final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
            instance.requireValue(test, exp, comp, "Some message");

            if (doFail) {
                fail();
            }
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Short value violation (Some message): short(" + test + ") " + comp.getOperator() + " 42", ex.getMessage());
        }
    }

    private void testCompare42(final int test, final NumberCompareOperator comp, final boolean doFail) {
        try {
            final int exp = 42;

            final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
            instance.requireValue(test, exp, comp, "Some message");

            if (doFail) {
                fail();
            }
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Integer value violation (Some message): int(" + test + ") " + comp.getOperator() + " 42", ex.getMessage());
        }
    }

    private void testCompare42(final long test, final NumberCompareOperator comp, final boolean doFail) {
        try {
            final long exp = 42;

            final NumberArgumentValidatorImpl instance = new NumberArgumentValidatorImpl();
            instance.requireValue(test, exp, comp, "Some message");

            if (doFail) {
                fail();
            }
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Long value violation (Some message): long(" + test + ") " + comp.getOperator() + " 42", ex.getMessage());
        }
    }
}
