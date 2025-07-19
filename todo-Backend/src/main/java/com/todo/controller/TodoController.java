package com.todo.controller;

import com.todo.dto.TodoDto;
import com.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create/list")
    public ResponseEntity<?> saveToDoData(@RequestBody TodoDto todoDto) {
        String response = todoService.saveTodoData(todoDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/list/data")
    public ResponseEntity<?> readTodoData(@RequestParam Long id) {
        return new ResponseEntity<>(todoService.readTodoData(id), HttpStatus.OK);
    }

    @PutMapping("/update/list/data")
    public ResponseEntity<?> updateTodoData(@RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(todoService.updateTodoData(todoDto));
    }

    @DeleteMapping("/delete/list/data")
    public ResponseEntity<?> deleteTodoData(@RequestParam Long id) {
        return new ResponseEntity<>(todoService.deleteTodoData(id), HttpStatus.OK);
    }
}
