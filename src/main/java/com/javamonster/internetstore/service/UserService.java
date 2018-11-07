package com.javamonster.internetstore.service;

import com.javamonster.internetstore.entity.User;

import java.util.Optional;

public interface UserService {
    void saveUser(User user);

    Optional<User> findByUsername(String username);
}
