package com.example.demosecurejdbcrest.sweater.controller;

import com.example.demosecurejdbcrest.sweater.entity.User;
import com.example.demosecurejdbcrest.sweater.service.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    private final UserServiceImplement userService;

    @Autowired
    public SecurityController(UserServiceImplement userService) {
        this.userService = userService;
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
    public String addUser(User user, Model model) {

        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {


        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("massage", "User successfully activated");
        } else {
            model.addAttribute("message", "User exists!");
        }

        return "login";
    }
}
