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
package com.github.marandus.argval;

import com.github.marandus.argval.enums.NumberCompareOperator;
import com.github.marandus.argval.validator.CollectionArgumentValidator;
import com.github.marandus.argval.validator.CollectionArgumentValidatorImpl;
import com.github.marandus.argval.validator.NumberArgumentValidator;
import com.github.marandus.argval.validator.NumberArgumentValidatorImpl;
import com.github.marandus.argval.validator.ObjectArgumentValidator;
import com.github.marandus.argval.validator.ObjectArgumentValidatorImpl;
import com.github.marandus.argval.validator.StringArgumentValidator;
import com.github.marandus.argval.validator.StringArgumentValidatorImpl;
import java.util.Collection;
import java.util.Map;

/**
 * An implementation of the argument validator that may be used as a bean in other applications. It
 * could be, for example, registered with a Spring application context or other similar solutions.
 * This class implements all validator interfaces but simply forwards the calls to the corresponding
 * internal validator instances.
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 * @since 0.1
 */
public class ArgumentValidatorBean implements CollectionArgumentValidator, NumberArgumentValidator, ObjectArgumentValidator, StringArgumentValidator {

    private final CollectionArgumentValidator collArgVal;
    private final NumberArgumentValidator numArgVal;
    private final ObjectArgumentValidator objArgVal;
    private final StringArgumentValidator stringArgVal;

    /**
     * Create a new validator bean instance. Uses the reference implementations of
     * {@link CollectionArgumentValidator}, {@link ObjectArgumentValidator}, and
     * {@link StringArgumentValidator}.
     *
     * @see CollectionArgumentValidatorImpl
     * @see ObjectArgumentValidatorImpl
     * @see StringArgumentValidatorImpl
     */
    public ArgumentValidatorBean() {
        this(new CollectionArgumentValidatorImpl(), new NumberArgumentValidatorImpl(), new ObjectArgumentValidatorImpl(), new StringArgumentValidatorImpl());
    }

    /**
     * Create a new validator bean instance. Uses the specified custom implementations of
     * {@link CollectionArgumentValidator}, {@link ObjectArgumentValidator}, and
     * {@link StringArgumentValidator}.
     *
     * @param collArgVal Custom implementation of collection validator
     * @param numArgVal Custom implementation of number validator
     * @param objArgVal Custom implementation of object validator
     * @param stringArgVal Custom implementation of string validator
     */
    public ArgumentValidatorBean(final CollectionArgumentValidator collArgVal, final NumberArgumentValidator numArgVal, final ObjectArgumentValidator objArgVal, final StringArgumentValidator stringArgVal) {
        this.collArgVal = collArgVal;
        this.numArgVal = numArgVal;
        this.objArgVal = objArgVal;
        this.stringArgVal = stringArgVal;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireNonBlank(final String arg, final String msg) {
        this.stringArgVal.requireNonBlank(arg, msg);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireLength(final String arg, final int len, final NumberCompareOperator comp, final String name) {
        this.stringArgVal.requireLength(arg, len, comp, name);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireNonNull(final Object arg, final String msg) {
        this.objArgVal.requireNonNull(arg, msg);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireNonEmpty(final Collection<?> arg, final String msg) {
        this.collArgVal.requireNonEmpty(arg, msg);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireNonEmpty(final Map<?, ?> arg, final String msg) {
        this.collArgVal.requireNonEmpty(arg, msg);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireLength(final Collection<?> arg, final int len, final NumberCompareOperator comp, final String name) {
        this.collArgVal.requireLength(arg, len, comp, name);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireLength(final Map<?, ?> arg, final int len, final NumberCompareOperator comp, final String name) {
        this.collArgVal.requireLength(arg, len, comp, name);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireValue(final byte arg, final byte value, final NumberCompareOperator comp, final String name) {
        this.numArgVal.requireValue(arg, value, comp, name);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireValue(final short arg, final short value, final NumberCompareOperator comp, final String name) {
        this.numArgVal.requireValue(arg, value, comp, name);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireValue(final int arg, final int value, final NumberCompareOperator comp, final String name) {
        this.numArgVal.requireValue(arg, value, comp, name);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireValue(final long arg, final long value, final NumberCompareOperator comp, final String name) {
        this.numArgVal.requireValue(arg, value, comp, name);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireNegative(long arg, String name) {
        this.numArgVal.requireNegative(arg, name);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requirePositive(long arg, String name) {
        this.numArgVal.requirePositive(arg, name);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void requireZero(long arg, String name) {
        this.numArgVal.requireZero(arg, name);
    }
}
