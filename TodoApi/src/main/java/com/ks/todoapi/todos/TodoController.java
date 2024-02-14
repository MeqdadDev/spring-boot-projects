package com.ks.todoapi.todos;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todos = todoService.getAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Todo> getTodoById(@PathVariable String id){
        Todo todo = todoService.getById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Todo> addNewTodo(@Valid @RequestBody Todo todo){
        Todo result = todoService.save(todo);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id){
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
