package com.example.demosecurejdbcrest.sweater.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, MASTER, GUEST ;

    @Override
    public String getAuthority() {
        return name();
    }
}
