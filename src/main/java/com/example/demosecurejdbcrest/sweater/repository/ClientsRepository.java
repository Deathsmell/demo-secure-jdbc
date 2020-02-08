package com.example.demosecurejdbcrest.sweater.repository;

import com.example.demosecurejdbcrest.sweater.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

    List<Clients> findByName (String name);
}
