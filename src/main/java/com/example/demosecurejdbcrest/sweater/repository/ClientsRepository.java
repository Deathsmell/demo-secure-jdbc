package com.example.demosecurejdbcrest.sweater.repository;

import com.example.demosecurejdbcrest.sweater.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

    List<Clients> findByName(String name);

    Clients findClientsById(Long id);

    void deleteById(Long id);
}
