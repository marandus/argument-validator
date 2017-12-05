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

/**
 * Definition of methods available for number argument validation.
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 * @since 0.2
 */
public interface NumberArgumentValidator {

    /**
     * Test the comparison of {@code arg} and {@code value} using the operator defined in
     * {@code comp} to be true. If the result of the comparison is false, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>"Byte value violation (" + name + "): byte(" + arg + ") " + comp.getOperator() + " " +
     * value</tt>
     *
     * @param arg Argument to test
     * @param value Value to be used as reference in comparison
     * @param comp Comparison operator to be used
     * @param name Name to be referenced in exception message
     *
     * @throws IllegalArgumentException if specified argument does not match value requirements
     * 
     * @since 0.2
     */
    public void requireValue(final byte arg, final byte value, final NumberCompareOperator comp, final String name);

    /**
     * Test the comparison of {@code arg} and {@code value} using the operator defined in
     * {@code comp} to be true. If the result of the comparison is false, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>"Short value violation (" + name + "): short(" + arg + ") " + comp.getOperator() + " " +
     * value</tt>
     *
     * @param arg Argument to test
     * @param value Value to be used as reference in comparison
     * @param comp Comparison operator to be used
     * @param name Name to be referenced in exception message
     *
     * @throws IllegalArgumentException if specified argument does not match value requirements
     *
     * @since 0.2
     */
    public void requireValue(final short arg, final short value, final NumberCompareOperator comp, final String name);

    /**
     * Test the comparison of {@code arg} and {@code value} using the operator defined in
     * {@code comp} to be true. If the result of the comparison is false, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>"Integer value violation (" + name + "): int(" + arg + ") " + comp.getOperator() + " " +
     * value</tt>
     *
     * @param arg Argument to test
     * @param value Value to be used as reference in comparison
     * @param comp Comparison operator to be used
     * @param name Name to be referenced in exception message
     *
     * @throws IllegalArgumentException if specified argument does not match value requirements
     *
     * @since 0.2
     */
    public void requireValue(final int arg, final int value, final NumberCompareOperator comp, final String name);

    /**
     * Test the comparison of {@code arg} and {@code value} using the operator defined in
     * {@code comp} to be true. If the result of the comparison is false, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>"Long value violation (" + name + "): long(" + arg + ") " + comp.getOperator() + " " +
     * value</tt>
     *
     * @param arg Argument to test
     * @param value Value to be used as reference in comparison
     * @param comp Comparison operator to be used
     * @param name Name to be referenced in exception message
     *
     * @throws IllegalArgumentException if specified argument does not match value requirements
     *
     * @since 0.2
     */
    public void requireValue(final long arg, final long value, final NumberCompareOperator comp, final String name);

    /**
     * Test the value of {@code arg} to be less than zero. If the value is zero or greater, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>"Value is not negative (" + name + "): " + arg</tt>
     *
     * @param arg Argument to test
     * @param name Name to be referenced in exception message
     *
     * @throws IllegalArgumentException if specified argument does not match value requirements
     *
     * @since 0.2
     */
    public void requireNegative(final long arg, final String name);

    /**
     * Test the value of {@code arg} to be greater than zero. If the value is zero or less, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>"Value is not positive (" + name + "): " + arg</tt>
     *
     * @param arg Argument to test
     * @param name Name to be referenced in exception message
     *
     * @throws IllegalArgumentException if specified argument does not match value requirements
     *
     * @since 0.2
     */
    public void requirePositive(final long arg, final String name);

    /**
     * Test the value of {@code arg} to be zero. If the value is greater or less than zero, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>"Value is not zero (" + name + "): " + arg</tt>
     *
     * @param arg Argument to test
     * @param name Name to be referenced in exception message
     *
     * @throws IllegalArgumentException if specified argument does not match value requirements
     *
     * @since 0.2
     */
    public void requireZero(final long arg, final String name);

}
