package com.example.demosecurejdbcrest.sweater.repository;

import com.example.demosecurejdbcrest.sweater.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername (String username);
    void deleteById (Long id);
}
