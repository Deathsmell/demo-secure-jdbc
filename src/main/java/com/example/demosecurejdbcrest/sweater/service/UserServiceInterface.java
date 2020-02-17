package com.example.demosecurejdbcrest.sweater.service;


import com.example.demosecurejdbcrest.sweater.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public interface UserServiceInterface extends UserDetailsService {
    boolean saveUser(String username, User user, Map<String, String> form);
    boolean addUser(User user);
    Model findAll (Model model);

    boolean activateUser(String code) throws Exception;
}
