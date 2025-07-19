package com.todo.service;

import com.todo.dto.TodoDto;

public interface TodoService {
    String saveTodoData(TodoDto todoDto);
    TodoDto readTodoData(Long id);
    String updateTodoData(TodoDto todoDto);
    String deleteTodoData(Long id);
}
