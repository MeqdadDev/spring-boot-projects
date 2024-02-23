package com.ks.todoapi.todos;

import com.ks.todoapi.exceptions.ConflictException;
import com.ks.todoapi.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo getById(String id) {
        try {
            return todoRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Todo item with id[%s] was found in database.", id));
        }

    }

    public Todo save(Todo todo) {
        if (todoRepository.findByTitle(todo.getTitle()) != null ){
            throw new ConflictException("This title is duplicated, try another title.");
        }
        return todoRepository.save(todo);
    }

    public void delete(String id){
        todoRepository.deleteById(id);
    }
}
