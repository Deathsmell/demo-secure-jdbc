package com.example.demosecurejdbcrest.sweater.service;

import com.example.demosecurejdbcrest.sweater.entity.Clients;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ClientServiceInterface {

    Iterable<Clients> getClients();

    Iterable<Clients> getClientByName(String name);

    void createClient(String name, String address, MultipartFile file) throws IOException;

    Clients uploadClient(Clients clients, String name, String address, String mail) throws IOException;

    void deleteClient(Long id);

    Clients getClientById(Long id);

}
