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
 * Reference implementation of the {@link CollectionArgumentValidator} interface.
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 * @since 0.1
 */
public class CollectionArgumentValidatorImpl implements CollectionArgumentValidator {

    private final ObjectArgumentValidator objArgVal;

    /**
     * Create a new validator instance. Uses the reference implementation of
     * {@link ObjectArgumentValidator}.
     *
     * @see ObjectArgumentValidatorImpl
     */
    public CollectionArgumentValidatorImpl() {
        this(new ObjectArgumentValidatorImpl());
    }

    /**
     * Create a new validator instance. Uses the specified custom implementation of
     * {@link ObjectArgumentValidator}.
     *
     * @param objArgVal Custom implementation of object validator
     */
    public CollectionArgumentValidatorImpl(final ObjectArgumentValidator objArgVal) {
        this.objArgVal = objArgVal;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireNonEmpty(final Collection<?> arg, final String msg) {
        this.objArgVal.requireNonNull(arg, "requireNonEmpty(Collection<?>) parameter");

        if (arg.isEmpty()) {
            throw new IllegalArgumentException(msg + ": Collection is empty");
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireNonEmpty(final Map<?, ?> arg, final String msg) {
        this.objArgVal.requireNonNull(arg, "requireNonEmpty(Map<?,?>) parameter");

        if (arg.isEmpty()) {
            throw new IllegalArgumentException(msg + ": Map is empty");
        }
    }
}
