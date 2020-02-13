package com.example.demosecurejdbcrest.sweater.entity;

import javax.persistence.*;

@Entity
@Table (name = "client")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "filename")
    private String filename;

    public Clients() {
    }
    public Clients(String name, String address) {
        this.address = address;
        this.name = name;
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

    public String getFilename() {
        return filename;
    }

    public Clients setFilename(String filename) {
        this.filename = filename;
        return this;
    }
}
