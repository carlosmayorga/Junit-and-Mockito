package com.cmayorga.unittest.mockito.business.logic;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.cmayorga.unittest.mockito.data.api.TodoService;

public class TodoBusinessImplMockTest_NoAnnotations {

    /* This is how we can test(Using Mock) a method that
     * depends of an external API that brings data to our method.
     */
    @Test
    public void retrieveTodosRelatedToSpring_UsingMock() {
        TodoService todoServiceMock = mock(TodoService.class);
        
        List<String> todos = Arrays.asList("Learn Spring MVC",
                                           "Learn Spring", 
                                           "Learn to Play Tenis");
        
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        
        List<String> filteredTodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Dummy");
        
        // System.out.println(filteredTodos.get(1)); 
        
        assertEquals(2, filteredTodos.size());
        
    }
    
    @Test
    public void retrieveTodosRelatedToSpring_UsingBDD() {
        
        /* BDD isn't a different test, is make the test with the next syntax
         * using "Given" and "is" to make the test more easy to understand.
         */
        
        // Given
        TodoService todoServiceMock = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        
        List<String> todos = Arrays.asList("Learn Spring MVC",
                                           "Learn Spring", 
                                           "Learn to Play Tenis");
        
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        
        
        // When
        List<String> filteredTodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Dummy");
        
        // Then 
        assertEquals(filteredTodos.size(), 2);
    }
    
    @Test
    public void deleteTodosNotRelatedToSpring_UsingVerify() {

        TodoService todoServiceMock = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                                              "Learn Spring", 
                                              "Learn to Play Tenis",
                                              "Learn to Play Tenis");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(allTodos);


        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        
        verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring MVC");

        verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring");

        /* Thats mean that its verify that the method "deleteTodo" should delete
         * two times the option "Learn to play tenis", and its ok because the list 
         * has two times the option "Learn to play tenis".
         */ 
        verify(todoServiceMock, Mockito.times(2)).deleteTodo("Learn to Play Tenis");

    }
    
    @Test
    public void deleteTodosNotRelatedToSpring_UsingArgumentCaptor() {
        
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                                              "Learn Spring", 
                                              "Learn to Play Tenis");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allTodos);
        
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);


        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        
        verify(todoServiceMock).deleteTodo(argumentCaptor.capture());
        
        assertEquals(argumentCaptor.getValue(), "Learn to Play Tenis");
        
    }

}
