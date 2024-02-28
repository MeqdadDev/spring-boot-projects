package com.ks.todoapi.todos;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    public void whenGetAllTodos_ReturnJsonArray() throws Exception {
        Todo todo1 = new Todo("1", "Reading DDIA Book", "Designing Data-Intensive Applications");
        Todo todo2 = new Todo("2", "Make Breakfast", "Eggs, Humos, Labaneh");
        List<Todo> data = Arrays.asList(todo1, todo2);

        given(todoService.getAll()).willReturn(data);


        mockMvc.perform(
                get("/api/v1/todos/").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", equalTo(todo1.getTitle())));
    }

    @Test
    public void whenPostTodo_thenCreateTodo() throws Exception{
        Todo todo1 = new Todo("1", "Reading DDIA Book", "Designing Data-Intensive Applications");
        todo1.setTitle("NoSQL Distilled");
        todo1.setDescription("Read NoSQL Distilled Book");

        given(todoService.save(Mockito.any(Todo.class))).willReturn(todo1);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(
                post("/api/v1/todos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(todo1))
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is (todo1.getTitle())));
    }
}
