package com.ks.todoapi.todos;

import com.ks.todoapi.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void whenGetAll_ReturnTodoList(){
        Todo todo1 = new Todo("1", "Reading DDIA Book", "Designing Data-Intensive Applications");
        Todo todo2 = new Todo("2", "Make Breakfast", "Eggs, Humos, Labaneh");

        List<Todo> data = Arrays.asList(todo1, todo2);

        given(todoRepository.findAll())
                .willReturn(data);

        assertThat(todoService.getAll())
                .hasSize(2)
                .contains(todo1, todo2);
    }

    @Test
    public void whenGetById_TodoShouldBeFound(){
        Todo todo = new Todo("1", "Reading DDIA Book", "Designing Data-Intensive Applications");
        given(todoRepository.findById(anyString())).willReturn(Optional.ofNullable(todo));

        Todo result = todoService.getById("1");

        assertThat(result.getTitle()).containsIgnoringCase("book");
    }

    @Test
    public void whenInvalidId_TodoShouldNotBeFound() {
        // Arrange (set up mocks and expectations)
        given(todoRepository.findById(anyString())).willReturn(Optional.empty());

        // Act and Assert (execute code and assert expected behavior)
        Exception exception = assertThrows(NotFoundException.class, () -> {
            todoService.getById("1");  // Call the service method that should throw the exception
        });

        // Verify (ensure mocked methods were called as expected)
        verify(todoRepository).findById("1");  // Verify the repository was called with the correct ID
    }

}

