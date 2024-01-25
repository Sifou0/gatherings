package com.learning.crud.user.repository;

import com.learning.crud.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findUserByUsername(String username);
}
