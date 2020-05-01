package com.cmayorga.unittest.junit;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

    @Test
    public void mockListSizeMethod_Basic() { 
        // Explanation :
        
        // This is the SetUp
        List listMock = mock(List.class);
        
        // When Method call do something or test something
        when(listMock.size()).thenReturn(2);
        
        // Assert o Fail the Test
        assertEquals(2, listMock.size());
    }
    
    @Test
    public void mockListSizeMethod_MultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);
        
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
        assertEquals(4, listMock.size());
    }
    
    @Test
    public void mockListSizeMethod_Get() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("testingString");
        
        assertEquals("testingString", listMock.get(0));
    }
    
    @Test(expected=RuntimeException.class)
    public void mockListSizeMethod_TestException() {
        List listMock = mock(List.class);
        
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something error"));
        
        listMock.get(1);
    }
    
    

    

}
