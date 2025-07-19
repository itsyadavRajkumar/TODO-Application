package com.todo.service.impl;

import com.todo.entity.Todo;
import com.todo.repository.TodoRepo;
import com.todo.service.TodoService;
import org.springframework.stereotype.Service;

@Service
public class TodoServeImpl implements TodoService {
    private final TodoRepo todoRepo;

    public TodoServeImpl(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    @Override
    public String saveTodoData(Todo todo) {
        return "Successfully created the TODO with id: " + todoRepo.save(todo).getId();
    }

    @Override
    public Todo readTodoData(Long id) {
        return todoRepo.findById(id).orElse(null);
    }

    @Override
    public String updateTodoData(Todo todo) {
        StringBuilder message = new StringBuilder();
        todoRepo.findById(todo.getId()).ifPresentOrElse(
                existing -> {
                    todoRepo.save(todo);
                    message.append("Successfully updated the TODO data with id: ").append(todo.getId());
                },
                () -> {
                    message.append("Given ID didn't match any TODO");
                }
        );
        return message.toString();
    }


    @Override
    public String deleteTodoData(Long id) {
        StringBuilder message = new StringBuilder();
        todoRepo.findById(id).ifPresentOrElse(
                existing -> {
                    todoRepo.deleteById(id);
                    message.append("Delete Successfully with id: ").append(id);
                },
                () -> {
                    message.append("Given ID didn't match any TODO");
                }
        );
        return message.toString();
    }
}
