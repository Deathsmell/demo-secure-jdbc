package com.example.demosecurejdbcrest.sweater.controller;

import com.example.demosecurejdbcrest.sweater.entity.Role;
import com.example.demosecurejdbcrest.sweater.entity.User;
import com.example.demosecurejdbcrest.sweater.repository.UserRepository;
import com.example.demosecurejdbcrest.sweater.service.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final UserServiceImplement userService;

    @Autowired
    public UserController(UserServiceImplement userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Model model) {
        userService.findAll(model);
        return "userList";
    }

    @GetMapping("{user}")
    public String userEdit(@PathVariable User user, Model model) {
        model.addAttribute("roles", Role.values());
        model.addAttribute("user", user);
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userID") User user
    ) {

        boolean acsess = userService.saveUser(username,user,form);

//        добавить логику обработки ошибок...

        return "redirect:/user";
    }

}
