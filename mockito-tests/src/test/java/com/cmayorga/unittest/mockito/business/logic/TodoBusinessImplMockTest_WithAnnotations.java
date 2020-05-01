package com.cmayorga.unittest.mockito.business.logic;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.cmayorga.unittest.mockito.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockTest_WithAnnotations {

    @Mock
    TodoService todoServiceMock;
    
    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;
    
    @Captor
    ArgumentCaptor<String> argumentCaptor;
    
    
    @Test
    public void retrieveTodosRelatedToSpring_UsingMock() {
        
        List<String> todos = Arrays.asList("Learn Spring MVC",
                                           "Learn Spring", 
                                           "Learn to Play Tenis");
        
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        
        List<String> filteredTodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Dummy");
        
        assertEquals(2, filteredTodos.size());
        
    }
    
    @Test
    public void retrieveTodosRelatedToSpring_UsingBDD() {
        
        // Given
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

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                                              "Learn Spring", 
                                              "Learn to Play Tenis",
                                              "Learn to Play Tenis");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(allTodos);


        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        
        verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring MVC");

        verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring");

        verify(todoServiceMock, Mockito.times(2)).deleteTodo("Learn to Play Tenis");

    }
    
    @Test
    public void deleteTodosNotRelatedToSpring_UsingArgumentCaptor() {
        
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                                              "Learn Spring", 
                                              "Learn to Play Tenis");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allTodos);
        

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        
        verify(todoServiceMock).deleteTodo(argumentCaptor.capture());
        
        assertEquals(argumentCaptor.getValue(), "Learn to Play Tenis");
        
    }

}
