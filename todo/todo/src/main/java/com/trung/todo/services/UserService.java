package com.trung.todo.services;

import com.trung.todo.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto user);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void delete(Long id);

    UserDto login(UserDto user);
}
