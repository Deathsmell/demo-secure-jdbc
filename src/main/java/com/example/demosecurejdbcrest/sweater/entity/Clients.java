package com.example.demosecurejdbcrest.sweater.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    public Clients() {
    }

    public Long getId() {
        return id;
    }

    public Clients setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Clients setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Clients setAddress(String address) {
        this.address = address;
        return this;
    }
}
