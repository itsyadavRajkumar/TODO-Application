package com.todo.mapper;

import com.todo.dto.TodoDto;
import com.todo.entity.Todo;

public class TodoMapper {
    public static Todo dtoToEntity(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        return todo;
    }

    public static TodoDto entityTODto(Todo todo) {
        TodoDto todoDto = new TodoDto();
        todoDto.setTitle(todo.getTitle());
        todoDto.setDescription(todoDto.getDescription());
        todoDto.setId(todo.getId());
        return todoDto;
    }
}
