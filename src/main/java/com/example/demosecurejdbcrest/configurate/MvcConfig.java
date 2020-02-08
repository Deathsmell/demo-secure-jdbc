package com.example.demosecurejdbcrest.configurate;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class MvcConfig {
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry){

        viewControllerRegistry.addViewController("/login").setViewName("login");

    }
}
