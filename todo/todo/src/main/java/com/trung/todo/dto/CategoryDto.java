package com.trung.todo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private long id;

    private String name;

    private String description;

    private UserDto user;

    private List<TodoDto> todoDtoList;


}
