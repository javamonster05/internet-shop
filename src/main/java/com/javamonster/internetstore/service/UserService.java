package com.javamonster.internetstore.service;

import com.javamonster.internetstore.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
