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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Reference implementation of the {@link StringArgumentValidator} interface.
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 * @since 0.1
 */
@Slf4j
public class StringArgumentValidatorImpl implements StringArgumentValidator {

    private final ObjectArgumentValidator objArgVal;

    /**
     * Create a new validator instance. Uses the reference implementation of
     * {@link ObjectArgumentValidator}.
     *
     * @see ObjectArgumentValidatorImpl
     */
    public StringArgumentValidatorImpl() {
        this(new ObjectArgumentValidatorImpl());
    }

    /**
     * Create a new validator instance. Uses the specified custom implementation of
     * {@link ObjectArgumentValidator}.
     *
     * @param objArgVal Custom implementation of object validator
     */
    public StringArgumentValidatorImpl(final ObjectArgumentValidator objArgVal) {
        this.objArgVal = objArgVal;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireNonBlank(final String arg, final String msg) {
        if (StringUtils.isBlank(arg)) {
            throw new IllegalArgumentException(msg + ": " + arg);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireStringLength(final String arg, final int len, final NumberCompareOperator comp, final String name) {
        if(len == 0 && comp == NumberCompareOperator.EQUAL) {
            log.warn("Called requireStringLength() with length=0 and operator=EQUAL. You should use requireNonBlank() instead.");
        }
        this.objArgVal.requireNonNull(arg, "requireStringLength() parameter");

        final boolean result;

        switch (comp) {
            case EQUAL:
                result = (arg.length() == len);
                break;
            case GREATER:
                result = (arg.length() > len);
                break;
            case GREATER_EQUAL:
                result = (arg.length() >= len);
                break;
            case LESS:
                result = (arg.length() < len);
                break;
            case LESS_EQUAL:
                result = (arg.length() <= len);
                break;
            default:
                throw new IllegalArgumentException("Unknown value of NumberCompare: " + comp);
        }

        if (!result) {
            String msg = "String length violation (" + name + "): string(" + arg.length() + ") " + comp.getOperator() + " " + len;
            throw new IllegalArgumentException(msg);
        }
    }

}
