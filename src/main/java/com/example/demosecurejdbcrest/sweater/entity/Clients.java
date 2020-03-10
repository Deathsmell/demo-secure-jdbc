package com.example.demosecurejdbcrest.sweater.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "client")
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
    @Column(name = "mail")
    private String mail;

}
