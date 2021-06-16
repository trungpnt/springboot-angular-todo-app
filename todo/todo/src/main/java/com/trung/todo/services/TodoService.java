package com.trung.todo.services;

import com.trung.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto save(TodoDto todoDto);

    List<TodoDto> findAll();

    TodoDto findById(Long id);

    List<TodoDto> findByCategory(Long categoryId);

    void delete(Long id);
}
