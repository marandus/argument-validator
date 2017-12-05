/*
 * Copyright 2017 Thomas Rix.
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
package com.github.marandus.argval;

import com.github.marandus.argval.enums.NumberCompareOperator;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * Utility class to validate method arguments. This class provides static only methods for argument
 * validation. It passes all method calls to an internal instance of {@link ArgumentValidatorBean}.
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 * @since 0.1
 * @see ArgumentValidatorBean
 */
public class ArgumentValidator {

    private static final ArgumentValidatorBean VALIDATOR_BEAN = new ArgumentValidatorBean();

    /**
     * Test {@code arg} to be non-blank as defined by the
     * {@link StringUtils#isBlank(java.lang.CharSequence) StringUtils.isBlank()} method. If
     * {@code arg} is blank, an IllegalArgumentException will be raised. The exception message will
     * be constructed as follows:
     * <p>
     * <tt>msg + ": " + arg</tt>
     *
     * @param arg Argument to test
     * @param msg Message used to construct the exception message
     *
     * @throws IllegalArgumentException if specified argument is blank
     *
     * @since 0.1
     */
    public static void requireNonBlank(final String arg, final String msg) {
        VALIDATOR_BEAN.requireNonBlank(arg, msg);
    }

    /**
     * Test the length {@code arg} against the provided length using the specified compare operator.
     * If the result of the comparison is false, an IllegalArgumentException will be raised. The
     * exception message will be constructed as follows:
     * <p>
     * <tt>"String length violation (" + name + "): string(" + arg.length() + ") " +
     * comp.getOperator() + " " + len</tt>
     *
     * @param arg String to test
     * @param len Value to be used as reference in comparison
     * @param comp Comparison operator to be used
     * @param name Name to be referenced in exception message
     *
     * @throws IllegalArgumentException if specified argument does not match length requirements
     *
     * @since 0.1
     */
    public static void requireStringLength(final String arg, final int len, final NumberCompareOperator comp, final String name) {
        VALIDATOR_BEAN.requireLength(arg, len, comp, name);
    }

    /**
     * Test {@code arg} to be non-null as defined by the
     * {@link Objects#isNull(java.lang.Object) Objects.isNull()} method. If {@code arg} is null, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>"NULL: " + msg</tt>
     *
     * @param arg Argument to test
     * @param msg Message used to construct the exception message
     *
     * @throws IllegalArgumentException if specified argument is null
     *
     * @since 0.1
     */
    public static void requireNonNull(final Object arg, final String msg) {
        VALIDATOR_BEAN.requireNonNull(arg, msg);
    }

    /**
     * Test {@code arg} to be non-null and not empty. If the collection is {@code null} or empty, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>msg + ": Collection is empty"</tt>
     *
     * @param arg Argument to test
     * @param msg Message used to construct the exception message
     *
     * @throws IllegalArgumentException if specified argument is empty or null
     *
     * @since 0.2
     */
    public static void requireNonEmpty(final Collection<?> arg, final String msg) {
        VALIDATOR_BEAN.requireNonEmpty(arg, msg);
    }

    /**
     * Test {@code arg} to be non-null and not empty. If the map is {@code null} or empty, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>msg + ": Map is empty"</tt>
     *
     * @param arg Argument to test
     * @param msg Message used to construct the exception message
     *
     * @throws IllegalArgumentException if specified argument is empty or null
     *
     * @since 0.2
     */
    public static void requireNonEmpty(final Map<?, ?> arg, final String msg) {
        VALIDATOR_BEAN.requireNonEmpty(arg, msg);
    }

    /**
     * Test the size of {@code arg}, as defined by {@code Collection.size()}, against the provided
     * length using the specified compare operator. If the result of the comparison is false, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>"Collection size violation (" + name + "): Collection(" + arg.size() + ") " +
     * comp.getOperator() + " " + len</tt>
     *
     * @param arg Collection to test
     * @param len Value to be used as reference in comparison
     * @param comp Comparison operator to be used
     * @param name Name to be referenced in exception message
     *
     * @throws IllegalArgumentException if specified argument does not match length requirements
     *
     * @since 0.2
     */
    public static void requireLength(final Collection<?> arg, final int len, final NumberCompareOperator comp, final String name) {
        VALIDATOR_BEAN.requireLength(arg, len, comp, name);
    }

    /**
     * Test the size of {@code arg}, as defined by {@code Map.size()}, against the provided length
     * using the specified compare operator. If the result of the comparison is false, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>"Map size violation (" + name + "): Map(" + arg.size() + ") " + comp.getOperator() + " "
     * + len</tt>
     *
     * @param arg Map to test
     * @param len Value to be used as reference in comparison
     * @param comp Comparison operator to be used
     * @param name Name to be referenced in exception message
     *
     * @throws IllegalArgumentException if specified argument does not match length requirements
     *
     * @since 0.2
     */
    public static void requireLength(final Map<?, ?> arg, final int len, final NumberCompareOperator comp, final String name) {
        VALIDATOR_BEAN.requireLength(arg, len, comp, name);
    }

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
    public void requireValue(final byte arg, final byte value, final NumberCompareOperator comp, final String name) {
        VALIDATOR_BEAN.requireValue(arg, value, comp, name);
    }

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
    public void requireValue(final short arg, final short value, final NumberCompareOperator comp, final String name) {
        VALIDATOR_BEAN.requireValue(arg, value, comp, name);
    }

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
    public void requireValue(final int arg, final int value, final NumberCompareOperator comp, final String name) {
        VALIDATOR_BEAN.requireValue(arg, value, comp, name);
    }

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
    public void requireValue(final long arg, final long value, final NumberCompareOperator comp, final String name) {
        VALIDATOR_BEAN.requireValue(arg, value, comp, name);
    }

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
    public void requireNegative(long arg, String name) {
        VALIDATOR_BEAN.requireNegative(arg, name);
    }

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
    public void requirePositive(long arg, String name) {
        VALIDATOR_BEAN.requirePositive(arg, name);
    }

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
    public void requireZero(long arg, String name) {
        VALIDATOR_BEAN.requireZero(arg, name);
    }

    /**
     * Private constructor, static only class
     */
    private ArgumentValidator() {

    }
}
