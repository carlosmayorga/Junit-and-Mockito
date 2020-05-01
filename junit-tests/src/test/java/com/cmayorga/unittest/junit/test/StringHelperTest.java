package com.cmayorga.unittest.junit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cmayorga.unittest.junit.test.StringHelper;

public class StringHelperTest {

    StringHelper helper = new StringHelper();
    
    // Is important to use de convention : method_testcase
    
    /* A long time ago, the JUnit convention said that 
     * was important to begin the method with the word 
     * "test" but now we have the annotation @test, so is not necessary.
     */
    @Test
    public void truncateAInFirst2Positions_testcase1() {
        String actual = helper.truncateAInFirst2Positions("AACD");
        String expected = "CD";
        assertEquals(expected, actual);
    }
    
    @Test
    public void truncateAInFirst2Positions_testcase2() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }
    
    @Test
    public void areFirstAndLastTwoCharactersTheSame_testcase1() {
        assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("AAB"));
    }
    
    @Test
    public void areFirstAndLastTwoCharactersTheSame_testcase2() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("AAb"));
    }

}
