package com.ks.todoapi.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo getById(String id) {
        return todoRepository.findById(id).get();
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(String id){
        todoRepository.deleteById(id);
    }
}
