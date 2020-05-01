package com.cmayorga.unittest.mockito.business.logic;

import java.util.ArrayList;
import java.util.List;

import com.cmayorga.unittest.mockito.data.api.TodoService;

public class TodoBusinessImpl {
          // TodoBusinessImpl is the System Under we make the Tests
    
    private TodoService todoService;
    /* For Practice, TodoService is a "Dependency" that the implement 
     * is not here because TodoService could be an webService or APi
     */
    
    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }
    
    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> todos = todoService.retrieveTodos(user);
        
        for(String todo:todos) {
            if(todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        
        return filteredTodos;
    }
    
    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (!todo.contains("Spring")) {
                System.out.println(todo);
                todoService.deleteTodo(todo);
            }
            else {
                System.out.println(todo);
            }
        }
    }

}
