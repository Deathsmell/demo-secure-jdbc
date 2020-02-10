package com.example.demosecurejdbcrest.sweater.entity;

import javax.persistence.*;

@Entity
@Table (name = "client")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "address")
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
