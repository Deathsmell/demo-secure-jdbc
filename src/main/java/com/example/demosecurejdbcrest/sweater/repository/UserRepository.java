package com.example.demosecurejdbcrest.sweater.repository;

import com.example.demosecurejdbcrest.sweater.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    UserDetails findByUsername(String username);

    void deleteById(Long id);

    User findByActivationCode(String code);
}
