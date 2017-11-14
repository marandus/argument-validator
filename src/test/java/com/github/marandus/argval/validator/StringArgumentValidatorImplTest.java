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
public class StringArgumentValidatorImplTest {

    @Test
    public void testRequireNonBlank() {
        final String test = "Test string";

        final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
        instance.requireNonBlank(test, "Some message");
    }

    @Test
    public void testRequireNonBlank_NULL() {
        final String test = null;

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireNonBlank(test, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Some message: null", ex.getMessage());
        }
    }

    @Test
    public void testRequireNonBlank_EMPTY() {
        final String test = "";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireNonBlank(test, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Some message: ", ex.getMessage());
        }
    }

    @Test
    public void testRequireNonBlank_WHITESPACE() {
        final String test = "\t";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireNonBlank(test, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Some message: \t", ex.getMessage());
        }
    }

    @Test
    public void testRequireStringLength_NULL() {
        final String test = null;

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireStringLength(test, 4, NumberCompareOperator.EQUAL, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("NULL: requireStringLength() parameter", ex.getMessage());
        }
    }

    @Test
    public void testRequireStringLength_NEGLEN() {
        final String test = "0123";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireStringLength(test, -1, NumberCompareOperator.EQUAL, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Negative requireStringLength() length parameter", ex.getMessage());
        }
    }

    @Test
    public void testRequireStringLength_EQUAL_4_4() {
        final String test = "0123";

        final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
        instance.requireStringLength(test, 4, NumberCompareOperator.EQUAL, "Some message");
    }

    @Test
    public void testRequireStringLength_EQUAL_4_3() {
        final String test = "012";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireStringLength(test, 4, NumberCompareOperator.EQUAL, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("String length violation (Some message): string(" + test.length() + ") " + NumberCompareOperator.EQUAL.getOperator() + " 4", ex.getMessage());
        }
    }

    @Test
    public void testRequireStringLength_EQUAL_4_5() {
        final String test = "01234";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireStringLength(test, 4, NumberCompareOperator.EQUAL, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("String length violation (Some message): string(" + test.length() + ") " + NumberCompareOperator.EQUAL.getOperator() + " 4", ex.getMessage());
        }
    }

    @Test
    public void testRequireStringLength_GREATER_4_5() {
        final String test = "01235";

        final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
        instance.requireStringLength(test, 4, NumberCompareOperator.GREATER, "Some message");
    }

    @Test
    public void testRequireStringLength_GREATER_4_4() {
        final String test = "0123";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireStringLength(test, 4, NumberCompareOperator.GREATER, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("String length violation (Some message): string(" + test.length() + ") " + NumberCompareOperator.GREATER.getOperator() + " 4", ex.getMessage());
        }
    }

    @Test
    public void testRequireStringLength_GREATER_4_3() {
        final String test = "012";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireStringLength(test, 4, NumberCompareOperator.GREATER, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("String length violation (Some message): string(" + test.length() + ") " + NumberCompareOperator.GREATER.getOperator() + " 4", ex.getMessage());
        }
    }

    @Test
    public void testRequireStringLength_GREATER_EQUAL_4_5() {
        final String test = "01235";

        final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
        instance.requireStringLength(test, 4, NumberCompareOperator.GREATER_EQUAL, "Some message");
    }

    @Test
    public void testRequireStringLength_GREATER_EQUAL_4_4() {
        final String test = "0123";

        final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
        instance.requireStringLength(test, 4, NumberCompareOperator.GREATER_EQUAL, "Some message");
    }

    @Test
    public void testRequireStringLength_GREATER_EQUAL_4_3() {
        final String test = "012";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireStringLength(test, 4, NumberCompareOperator.GREATER_EQUAL, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("String length violation (Some message): string(" + test.length() + ") " + NumberCompareOperator.GREATER_EQUAL.getOperator() + " 4", ex.getMessage());
        }
    }

    @Test
    public void testRequireStringLength_LESS_4_3() {
        final String test = "012";

        final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
        instance.requireStringLength(test, 4, NumberCompareOperator.LESS, "Some message");
    }

    @Test
    public void testRequireStringLength_LESS_4_4() {
        final String test = "0123";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireStringLength(test, 4, NumberCompareOperator.LESS, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("String length violation (Some message): string(" + test.length() + ") " + NumberCompareOperator.LESS.getOperator() + " 4", ex.getMessage());
        }
    }

    @Test
    public void testRequireStringLength_LESS_4_5() {
        final String test = "01234";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireStringLength(test, 4, NumberCompareOperator.LESS, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("String length violation (Some message): string(" + test.length() + ") " + NumberCompareOperator.LESS.getOperator() + " 4", ex.getMessage());
        }
    }

    @Test
    public void testRequireStringLength_LESS_EQUAL_4_3() {
        final String test = "012";

        final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
        instance.requireStringLength(test, 4, NumberCompareOperator.LESS_EQUAL, "Some message");
    }

    @Test
    public void testRequireStringLength_LESS_EQUAL_4_4() {
        final String test = "0123";

        final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
        instance.requireStringLength(test, 4, NumberCompareOperator.LESS_EQUAL, "Some message");
    }

    @Test
    public void testRequireStringLength_LESS_EQUAL_4_5() {
        final String test = "01234";

        try {
            final StringArgumentValidatorImpl instance = new StringArgumentValidatorImpl();
            instance.requireStringLength(test, 4, NumberCompareOperator.LESS_EQUAL, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("String length violation (Some message): string(" + test.length() + ") " + NumberCompareOperator.LESS_EQUAL.getOperator() + " 4", ex.getMessage());
        }
    }
}
