package com.trung.todo.repositories;

import com.trung.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

        Optional<User> findUserByEmailAndPassword(String email, String password);
}
