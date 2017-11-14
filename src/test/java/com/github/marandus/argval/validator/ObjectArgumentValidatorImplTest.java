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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 */
public class ObjectArgumentValidatorImplTest {

    @Test
    public void testRequireNonNull() {
        final Object test = new Object();

        final ObjectArgumentValidatorImpl instance = new ObjectArgumentValidatorImpl();
        instance.requireNonNull(test, "Test object");
    }

    @Test
    public void testRequireNonNull_NULL() {
        try {
            final ObjectArgumentValidatorImpl instance = new ObjectArgumentValidatorImpl();
            instance.requireNonNull(null, "Test object");

            fail();
        }
        catch (IllegalArgumentException ex) {
            assertEquals("NULL: Test object", ex.getMessage());
        }
    }

}
