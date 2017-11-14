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
     */
    public static void requireNonBlank(String arg, String msg) {
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
     */
    public static void requireStringLength(String arg, int len, NumberCompareOperator comp, String name) {
        VALIDATOR_BEAN.requireStringLength(arg, len, comp, name);
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
     */
    public static void requireNonNull(Object arg, String msg) {
        VALIDATOR_BEAN.requireNonNull(arg, msg);
    }

    /**
     * Private constructor, static only class
     */
    private ArgumentValidator() {

    }
}
