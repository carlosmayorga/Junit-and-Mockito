package com.cmayorga.unittest.junit.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

    @Test
    public void arrayTesting_TestWithArrayEquals() {
     int[] actuals = {12, 3, 4, 5};
     int[] expecteds = {3, 4, 5, 12};
     
     Arrays.sort(actuals);
     
     assertArrayEquals(expecteds, actuals);
    }
    
    @Test(expected=NullPointerException.class)
    // This is the way to testing an exception
    public void arrayTesting_TestingANullException() {
        int[] number = null;
        Arrays.sort(number);
    }
    
    @Test(timeout=100)
    // This is the way to testing performance in milliseconds
    public void arrayTesting_TestPerformance() {
        int array[] = {12, 23, 4};
        for(int i=1; i<=100; i++)
        {
            array[0] = i;
            Arrays.sort(array);
        }
    }
}
