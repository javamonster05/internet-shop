package com.javamonster.internetstore.service.impl;

import com.javamonster.internetstore.entity.User;
import com.javamonster.internetstore.repository.RoleRepository;
import com.javamonster.internetstore.repository.UserRepository;
import com.javamonster.internetstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public static String USER_ROLE = "ROLE_USER";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(roleRepository.findByRole(USER_ROLE)));
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByName(username);
    }
}
