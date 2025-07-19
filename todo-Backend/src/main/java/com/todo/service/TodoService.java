package com.todo.service;

import com.todo.entity.Todo;

public interface TodoService {
    String saveTodoData(Todo todo);
    Todo readTodoData(Long id);
    String updateTodoData(Todo todo);
    String deleteTodoData(Long id);
}
