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
 * Reference implementation of the {@link NumberArgumentValidatorImpl} interface.
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 * @since 0.2
 */
public class NumberArgumentValidatorImpl implements NumberArgumentValidator {

    /**
     * Create a new validator instance.
     */
    public NumberArgumentValidatorImpl() {

    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireValue(final byte arg, final byte value, final NumberCompareOperator comp, final String name) {
        if (!comp.doComparison(arg, value)) {
            String msg = "Byte value violation (" + name + "): byte(" + arg + ") " + comp.getOperator() + " " + value;
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireValue(final short arg, final short value, final NumberCompareOperator comp, final String name) {
        if (!comp.doComparison(arg, value)) {
            String msg = "Short value violation (" + name + "): short(" + arg + ") " + comp.getOperator() + " " + value;
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireValue(final int arg, final int value, final NumberCompareOperator comp, final String name) {
        if (!comp.doComparison(arg, value)) {
            String msg = "Integer value violation (" + name + "): int(" + arg + ") " + comp.getOperator() + " " + value;
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireValue(final long arg, final long value, final NumberCompareOperator comp, final String name) {
        if (!comp.doComparison(arg, value)) {
            String msg = "Long value violation (" + name + "): long(" + arg + ") " + comp.getOperator() + " " + value;
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireNegative(long arg, String name) {
        try {
            this.requireValue(arg, 0L, NumberCompareOperator.LESS, name);
        }
        catch (IllegalArgumentException ex) {
            String msg = "Value is not negative (" + name + "): " + arg;
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requirePositive(long arg, String name) {
        try {
            this.requireValue(arg, 0L, NumberCompareOperator.GREATER, name);
        }
        catch (IllegalArgumentException ex) {
            String msg = "Value is not positive (" + name + "): " + arg;
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireZero(long arg, String name) {
        try {
            this.requireValue(arg, 0L, NumberCompareOperator.EQUAL, name);
        }
        catch (IllegalArgumentException ex) {
            String msg = "Value is not zero (" + name + "): " + arg;
            throw new IllegalArgumentException(msg);
        }
    }
}
