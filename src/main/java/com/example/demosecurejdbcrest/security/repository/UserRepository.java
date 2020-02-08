package com.example.demosecurejdbcrest.security.repository;

import com.example.demosecurejdbcrest.security.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername (String username);
}
