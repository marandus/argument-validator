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

import java.util.Collection;
import java.util.Map;

/**
 * Definition of methods available for Collection and Map argument validation.
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 * @since 0.1
 */
public interface CollectionArgumentValidator {

    /**
     * Test {@code arg} to be non-null and not empty. If the collection is {@code null} or empty, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>msg + ": Collection is empty"</tt>
     *
     * @param arg Argument to test
     * @param msg Message used to construct the exception message
     * @throws IllegalArgumentException if specified argument is empty or null
     */
    public void requireNonEmpty(final Collection<?> arg, final String msg);

    /**
     * Test {@code arg} to be non-null and not empty. If the map is {@code null} or empty, an
     * IllegalArgumentException will be raised. The exception message will be constructed as
     * follows:
     * <p>
     * <tt>msg + ": Map is empty"</tt>
     *
     * @param arg Argument to test
     * @param msg Message used to construct the exception message
     * @throws IllegalArgumentException if specified argument is empty or null
     */
    public void requireNonEmpty(final Map<?, ?> arg, final String msg);
}
