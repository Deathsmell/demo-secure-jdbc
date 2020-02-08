package com.example.demosecurejdbcrest.security.controller;

import com.example.demosecurejdbcrest.security.dao.Role;
import com.example.demosecurejdbcrest.security.dao.User;
import com.example.demosecurejdbcrest.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class SecurityController {

    private final UserRepository userRepository;

    @Autowired
    public SecurityController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User usernameFromDB = userRepository.findByUsername(user.getUsername());
        if (usernameFromDB != null){
            model.put("message", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.User));
        userRepository.save(user);
        return "redirect:/login";
    }
}