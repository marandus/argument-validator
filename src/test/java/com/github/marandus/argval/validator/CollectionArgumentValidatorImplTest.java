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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Rix (thomasrix@exodus-project.net)
 */
public class CollectionArgumentValidatorImplTest {

    @Test
    public void testRequireNonEmpty_Collection_String() {
        final Set<String> coll = new HashSet<>();
        coll.add("foo");

        final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
        instance.requireNonEmpty(coll, "Test collection");
    }

    @Test
    public void testRequireNonEmpty_Collection_String_NULL() {
        try {
            final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
            instance.requireNonEmpty((Set) null, "Test collection");

            fail();
        }
        catch(IllegalArgumentException ex) {
            assertEquals("NULL: requireNonEmpty(Collection<?>) parameter", ex.getMessage());
        }
    }

    @Test
    public void testRequireNonEmpty_Collection_String_EMPTY() {
        try {
            final Set<String> coll = new HashSet<>();

            final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
            instance.requireNonEmpty(coll, "Test collection");

            fail();
        }
        catch(IllegalArgumentException ex) {
            assertEquals("Test collection: Collection is empty", ex.getMessage());
        }
    }

    @Test
    public void testRequireNonEmpty_Map_String() {
        final Map<String, String> map = new HashMap<>();
        map.put("foo", "bar");

        final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
        instance.requireNonEmpty(map, "Test map");
    }

    @Test
    public void testRequireNonEmpty_Map_String_NULL() {
        try {
            final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
            instance.requireNonEmpty((Map) null, "Test map");

            fail();
        }
        catch(IllegalArgumentException ex) {
            assertEquals("NULL: requireNonEmpty(Map<?,?>) parameter", ex.getMessage());
        }
    }

    @Test
    public void testRequireNonEmpty_Map_String_EMPTY() {
        try {
            final Map<String, String> map = new HashMap<>();

            final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
            instance.requireNonEmpty(map, "Test map");

            fail();
        }
        catch(IllegalArgumentException ex) {
            assertEquals("Test map: Map is empty", ex.getMessage());
        }
    }
}
