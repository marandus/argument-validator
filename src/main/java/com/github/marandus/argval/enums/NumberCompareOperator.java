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
package com.github.marandus.argval.enums;

import lombok.Getter;

/**
 * Definition of comparison operators available for number comparisons.
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 * @since 0.1
 */
public enum NumberCompareOperator {
    EQUAL("=="),
    GREATER(">"),
    GREATER_EQUAL(">="),
    LESS("<"),
    LESS_EQUAL("<=");

    /**
     * String representation of operator.
     */
    @Getter
    private final String operator;

    /**
     *
     * @param op String representation of operator
     */
    private NumberCompareOperator(final String op) {
        this.operator = op;
    }

    /**
     * Perform the compare operation defined by this operator on the two argument {@code n1} and
     * {@code n2}.
     *
     * @param n1 Left hand side of comparison
     * @param n2 Right hand side of comparison
     * @return Result of comparison
     *
     * @since 0.2
     */
    public boolean doComparison(long n1, long n2) {
        switch (this) {
            case EQUAL:
                return (n1 == n2);
            case GREATER:
                return (n1 > n2);
            case GREATER_EQUAL:
                return (n1 >= n2);
            case LESS:
                return (n1 < n2);
            case LESS_EQUAL:
                return (n1 <= n2);
            default:
                throw new IllegalArgumentException("Unknown value of NumberCompare: " + this);
        }
    }
}
