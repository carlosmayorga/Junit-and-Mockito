package com.cmayorga.unittest.junit.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {

    @BeforeClass
    public static void setUpBeforeTestCases() {
        System.out.println("Before to run all test cases");
    }
    
    
    @Before
    // Run before every testCase
    public void beforeStart() {
        System.out.println("Before test");
    }
    
    @Test
    public void test1() {
        System.out.println("Test 1 executed");
    }
    
    @Test
    public void test2() {
        System.out.println("Test 2 executed");
    }
    
    
    @After
    // Run after every testCase
    public void tearDown() {
        System.out.println("After test");
    }
    
    @AfterClass
    public static void tearDownAfterTestCases() {
        System.out.println("After to run all test cases");
    }
    

}
