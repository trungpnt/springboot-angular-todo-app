package com.trung.todo.services.impl;


import com.trung.todo.dto.CategoryDto;
import com.trung.todo.dto.TodoDto;
import com.trung.todo.exception.EntityNotFoundException;
import com.trung.todo.exception.ErrorCodes;
import com.trung.todo.exception.InvalidEntityException;
import com.trung.todo.model.Category;
import com.trung.todo.model.Todo;
import com.trung.todo.repositories.CategoryRepository;
import com.trung.todo.repositories.TodoRepository;
import com.trung.todo.services.TodoService;
import com.trung.todo.validators.TodoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public TodoDto save(TodoDto todoDto) {
        List<String> errors = TodoValidator.validateTodo(todoDto);
        if (!errors.isEmpty()) {
            log.error("Todo is not valid {}", todoDto);
            throw new InvalidEntityException("Todo is not valid", ErrorCodes.TODO_NOT_VALID, errors);
        }
        return TodoDto.fromEntity(todoRepository.save(TodoDto.toEntity(todoDto)));
    }

    @Override
    public List<TodoDto> findAll() {
        return todoRepository.findAll().stream()
                .map(TodoDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto findById(Long id) {
        if (id == null) {
            log.error("User id is null");
            return null;
        }
        final Long categoryId = categoryRepository.findCategoryByTodoId(id);
        Category category = new Category();
        category.setId(categoryId);

        final Optional<Todo> todo = todoRepository.findById(id);
        todo.ifPresent(value -> value.setCategory(category));

        final TodoDto todoDto = TodoDto.fromEntity(todo.get());
        CategoryDto categoryDto = CategoryDto.fromEntity(category);
        todoDto.setCategoryDto(categoryDto);

        return Optional.of(todoDto).
                orElseThrow(() -> new EntityNotFoundException("No Todo found with ID = " + id, ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public List<TodoDto> findByCategory(Long categoryId) {
        return todoRepository.findTodoByCategoryId(categoryId).stream()
                .map(TodoDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Todo id is null");
            return;
        }
        todoRepository.deleteById(id);
    }
}
