package com.todo.service.impl;

import com.todo.dto.TodoDto;
import com.todo.entity.Todo;
import com.todo.mapper.TodoMapper;
import com.todo.repository.TodoRepo;
import com.todo.service.TodoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TodoServeImpl implements TodoService {
    private final TodoRepo todoRepo;

    public TodoServeImpl(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    @Override
    public String saveTodoData(TodoDto todoDto) {
        Todo todo = TodoMapper.dtoToEntity(todoDto);
        return "Successfully created the TODO with id: " + todoRepo.save(todo).getId();
    }

    @Override
    public TodoDto readTodoData(Long id) {
        Todo todo = todoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo with id " + id + " not found"));
        return TodoMapper.entityTODto(todo);
    }

    @Override
    public String updateTodoData(TodoDto todoDto) {
        StringBuilder message = new StringBuilder();
        todoRepo.findById(todoDto.getId()).ifPresentOrElse(
                existing -> {
                    Todo todo = TodoMapper.dtoToEntity(todoDto);
                    todo.setId(todoDto.getId());
                    todoRepo.save(todo);
                    message.append("Successfully updated the TODO data with id: ").append(todoDto.getId());
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
