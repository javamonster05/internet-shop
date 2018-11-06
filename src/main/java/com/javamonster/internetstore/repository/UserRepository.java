package com.javamonster.internetstore.repository;

import com.javamonster.internetstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByname(String name);
}
