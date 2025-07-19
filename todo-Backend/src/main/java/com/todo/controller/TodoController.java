package com.todo.controller;

import com.todo.entity.Todo;
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
    public ResponseEntity<?> saveToDoData(@RequestBody Todo todo) {
        String response = todoService.saveTodoData(todo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/list/data")
    public ResponseEntity<?> readTodoData(@RequestParam Long id) {
        return new ResponseEntity<>(todoService.readTodoData(id), HttpStatus.OK);
    }

    @PutMapping("/update/list/data")
    public ResponseEntity<?> updateTodoData(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.updateTodoData(todo));
    }

    @DeleteMapping("/delete/list/data")
    public ResponseEntity<?> deleteTodoData(@RequestParam Long id) {
        return new ResponseEntity<>(todoService.deleteTodoData(id), HttpStatus.OK);
    }
}
