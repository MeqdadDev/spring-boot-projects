package com.ks.todoapi.todos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

    Todo findByTitle(String title);
}
