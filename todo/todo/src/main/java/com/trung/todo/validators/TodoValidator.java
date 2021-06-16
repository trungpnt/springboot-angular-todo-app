package com.trung.todo.validators;

import com.trung.todo.dto.TodoDto;

import java.util.ArrayList;
import java.util.List;

public class TodoValidator{

    public static List<String> validateTodo(TodoDto todoDto) {
        List<String> errors = new ArrayList<>();
        if (todoDto == null) {
            errors.add("Please fill the title");
            errors.add("Please fill the description");
            errors.add("Please select a category");
            return errors;
        }
        if (todoDto.getTitle() == null || todoDto.getTitle().isBlank()) {
            errors.add("Please fill the title");
        }
        if (todoDto.getDescription() == null || todoDto.getDescription().isBlank()) {
            errors.add("Please fill the description");
        }
        if (todoDto.getCategoryDto() == null ) {
            errors.add("Please select a category");
        }
        return errors;
    }
}
