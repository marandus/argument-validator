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
 * Definition of methods available for String argument validation.
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 * @since 0.1
 */
public interface StringArgumentValidator {

    /**
     * Test {@code arg} to be non-blank as defined by the
     * {@code StringUtils#isBlank(java.lang.CharSequence)} method. If {@code arg} is blank, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>msg + ": " + arg</tt>
     *
     * @param arg Argument to test
     * @param msg Message used to construct the exception message
     *
     * @throws IllegalArgumentException if specified argument is blank
     */
    public void requireNonBlank(final String arg, final String msg);

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
    public void requireStringLength(final String arg, final int len, final NumberCompareOperator comp, final String name);
}
