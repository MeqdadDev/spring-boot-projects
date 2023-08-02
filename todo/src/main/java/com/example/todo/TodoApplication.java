package com.example.todo;

import com.example.todo.entity.Todo;
import com.example.todo.entity.Users;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Users user = new Users();
        user.setPassword("Hashed Password");
        user.setUsername("Meqdad");

        Todo todo = new Todo();
        todo.setContent("Learn Java");

        user.getTodoList().add(todo);

        todoRepository.save(todo);
        userRepository.save(user);

    }
}
