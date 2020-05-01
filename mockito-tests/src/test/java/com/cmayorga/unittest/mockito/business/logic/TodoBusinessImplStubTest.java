package com.cmayorga.unittest.mockito.business.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cmayorga.unittest.mockito.data.api.TodoService;
import com.cmayorga.unittest.mockito.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

    /* This is how we can test(Using Stub) a method that
     * depends of an external API that brings data to our method.
     */
    @Test
    public void retrieveTodosRelatedToSpring_UsingStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        
        List<String> filteredTodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Dummy");
        
        System.out.println(filteredTodos.get(1)); 
        
        assertEquals(2, filteredTodos.size());
    }

}
