package edu.ucsb.cs56.pconrad.parsing;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestParser {
    public static boolean doesItParse(final String input) {
        return new Parser(input).parse();
    }

    @Test
    public void testEmptyString() {
        assertFalse(doesItParse(""));
    }

    @Test
    public void testSingleIntegerDirectly() {
        try {
            new Parser("1").parseDigit(0);
        } catch (ParseException e) {
            fail();
        }
    }
    
    @Test
    public void testSingleInteger() {
        assertTrue(doesItParse("1"));
    }

    @Test
    public void testMultiInteger() {
        assertTrue(doesItParse("12"));
    }

    @Test
    public void testAddSingleIntegers() {
        assertTrue(doesItParse("1+2"));
    }

    @Test
    public void testAddSingleWithMultipleInteger() {
        assertTrue(doesItParse("1+23"));
    }

    @Test
    public void testAddMultiIntegers() {
        assertTrue(doesItParse("12+34"));
    }

    @Test
    public void testMinusSingleIntegers() {
        assertTrue(doesItParse("1-2"));
    }

    @Test
    public void testMinusSingleWithMultipleInteger() {
        assertTrue(doesItParse("1-23"));
    }

    @Test
    public void testMinusMultiIntegers() {
        assertTrue(doesItParse("12-34"));
    }

    @Test
    public void testAddWithMinus() {
        assertTrue(doesItParse("12+34-56-78+90"));
    }
    
    @Test
    public void testBigThing() {
        assertTrue(doesItParse("127+82+76-2-90"));
    }
}
