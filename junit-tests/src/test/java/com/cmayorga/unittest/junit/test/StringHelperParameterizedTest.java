package com.cmayorga.unittest.junit.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.cmayorga.unittest.junit.test.StringHelper;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

    StringHelper helper = new StringHelper();
    
    private String actual;
    private String expected;
    
    public StringHelperParameterizedTest(String expected, String actual) {
        this.expected = expected;
        this.actual = actual;
        
        System.out.println("Expected: "+this.expected +" actual: "+this.actual);
    }

    @Parameters
    public static Collection<String[]> testConditions() {
        String actualAndExpectedParams[][] = { {"Di",       "AADi"}, 
                                               {"Do",       "AADo"} };
                                              // expected    actual 
        return Arrays.asList(actualAndExpectedParams);
    }
    
    @Test
    public void truncateAInFirst2Positions_testcase1() {
        assertEquals(expected, helper.truncateAInFirst2Positions(actual));
    }
    
    @Test
    public void truncateAInFirst2Positions_testcase2() {
        assertEquals(expected, helper.truncateAInFirst2Positions(actual));
    }
    

}
