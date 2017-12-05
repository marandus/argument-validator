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
import java.util.ArrayList;
import java.util.Collection;
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
        catch (IllegalArgumentException ex) {
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
        catch (IllegalArgumentException ex) {
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
        catch (IllegalArgumentException ex) {
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
        catch (IllegalArgumentException ex) {
            assertEquals("Test map: Map is empty", ex.getMessage());
        }
    }

    @Test
    public void testRequireLength_Collection_NULL() {
        final Collection<String> test = null;

        try {
            final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
            instance.requireLength(test, 1, NumberCompareOperator.EQUAL, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("NULL: requireLength(Collection<?>) parameter", ex.getMessage());
        }
    }

    @Test
    public void testRequireLength_Collection_NEGLEN() {
        final Collection<String> test = new ArrayList<>();

        try {
            final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
            instance.requireLength(test, -1, NumberCompareOperator.EQUAL, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Negative requireLength(Collection<?>) length parameter", ex.getMessage());
        }
    }

    @Test
    public void testRequireLength_Collection_EQUAL_2_2() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");

        this.testCompare2(test, NumberCompareOperator.EQUAL, false);
    }

    @Test
    public void testRequireLength_Collection_EQUAL_2_1() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");

        this.testCompare2(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireLength_Collection_EQUAL_2_3() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");

        this.testCompare2(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireLength_Collection_GREATER_2_3() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");

        this.testCompare2(test, NumberCompareOperator.GREATER, false);
    }

    @Test
    public void testRequireLength_Collection_GREATER_2_2() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");

        this.testCompare2(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireLength_Collection_GREATER_2_1() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");

        this.testCompare2(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireLength_Collection_GREATER_EQUAL_2_3() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");

        this.testCompare2(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireLength_Collection_GREATER_EQUAL_2_2() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");

        this.testCompare2(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireLength_Collection_GREATER_EQUAL_2_1() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");

        this.testCompare2(test, NumberCompareOperator.GREATER_EQUAL, true);
    }

    @Test
    public void testRequireLength_Collection_LESS_2_3() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");

        this.testCompare2(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireLength_Collection_LESS_2_2() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");

        this.testCompare2(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireLength_Collection_LESS_2_1() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");

        this.testCompare2(test, NumberCompareOperator.LESS, false);
    }

    @Test
    public void testRequireLength_Collection_LESS_EQUAL_2_3() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");

        this.testCompare2(test, NumberCompareOperator.LESS_EQUAL, true);
    }

    @Test
    public void testRequireLength_Collection_LESS_EQUAL_2_2() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");

        this.testCompare2(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireLength_Collection_LESS_EQUAL_2_1() {
        final Collection<String> test = new ArrayList<>();
        test.add("1");

        this.testCompare2(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireLength_Map_NULL() {
        final Map<String, String> test = null;

        try {
            final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
            instance.requireLength(test, 1, NumberCompareOperator.EQUAL, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("NULL: requireLength(Map<?,?>) parameter", ex.getMessage());
        }
    }

    @Test
    public void testRequireLength_Map_NEGLEN() {
        final Map<String, String> test = new HashMap<>();

        try {
            final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
            instance.requireLength(test, -1, NumberCompareOperator.EQUAL, "Some message");
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Negative requireLength(Map<?,?>) length parameter", ex.getMessage());
        }
    }

    @Test
    public void testRequireLength_Map_EQUAL_2_2() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");

        this.testCompare2(test, NumberCompareOperator.EQUAL, false);
    }

    @Test
    public void testRequireLength_Map_EQUAL_2_1() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");

        this.testCompare2(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireLength_Map_EQUAL_2_3() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");
        test.put("3", "3");

        this.testCompare2(test, NumberCompareOperator.EQUAL, true);
    }

    @Test
    public void testRequireLength_Map_GREATER_2_3() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");
        test.put("3", "3");

        this.testCompare2(test, NumberCompareOperator.GREATER, false);
    }

    @Test
    public void testRequireLength_Map_GREATER_2_2() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");

        this.testCompare2(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireLength_Map_GREATER_2_1() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");

        this.testCompare2(test, NumberCompareOperator.GREATER, true);
    }

    @Test
    public void testRequireLength_Map_GREATER_EQUAL_2_3() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");
        test.put("3", "3");

        this.testCompare2(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireLength_Map_GREATER_EQUAL_2_2() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");

        this.testCompare2(test, NumberCompareOperator.GREATER_EQUAL, false);
    }

    @Test
    public void testRequireLength_Map_GREATER_EQUAL_2_1() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");

        this.testCompare2(test, NumberCompareOperator.GREATER_EQUAL, true);
    }

    @Test
    public void testRequireLength_Map_LESS_2_3() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");
        test.put("3", "3");

        this.testCompare2(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireLength_Map_LESS_2_2() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");

        this.testCompare2(test, NumberCompareOperator.LESS, true);
    }

    @Test
    public void testRequireLength_Map_LESS_2_1() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");

        this.testCompare2(test, NumberCompareOperator.LESS, false);
    }

    @Test
    public void testRequireLength_Map_LESS_EQUAL_2_3() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");
        test.put("3", "3");

        this.testCompare2(test, NumberCompareOperator.LESS_EQUAL, true);
    }

    @Test
    public void testRequireLength_Map_LESS_EQUAL_2_2() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");

        this.testCompare2(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    @Test
    public void testRequireLength_Map_LESS_EQUAL_2_1() {
        final Map<String, String> test = new HashMap<>();
        test.put("1", "1");

        this.testCompare2(test, NumberCompareOperator.LESS_EQUAL, false);
    }

    private void testCompare2(final Collection<?> test, final NumberCompareOperator comp, final boolean doFail) {
        try {
            final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
            instance.requireLength(test, 2, comp, "Some message");

            if (doFail) {
                fail();
            }
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Collection size violation (Some message): Collection(" + test.size() + ") " + comp.getOperator() + " 2", ex.getMessage());
        }
    }

    private void testCompare2(final Map<?, ?> test, final NumberCompareOperator comp, final boolean doFail) {
        try {
            final CollectionArgumentValidatorImpl instance = new CollectionArgumentValidatorImpl();
            instance.requireLength(test, 2, comp, "Some message");

            if (doFail) {
                fail();
            }
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Map size violation (Some message): Map(" + test.size() + ") " + comp.getOperator() + " 2", ex.getMessage());
        }
    }
}
