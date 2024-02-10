package com.ks.todoapi.todos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private List<Todo> data = Arrays.asList(
            new Todo(1, "Say Alhamdulellah", "Thanking God"),
            new Todo(2, "Make Breakfast", "Eating breakfast with my wife")
            );
    @GetMapping(value = {"", "/"})
    public List<Todo> listTodos(){
        return data;
    }


}
