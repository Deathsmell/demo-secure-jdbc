package com.example.demosecurejdbcrest.sweater.service;

import com.example.demosecurejdbcrest.sweater.entity.Clients;
import com.example.demosecurejdbcrest.sweater.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceInterfaceImpl implements ClientServiceInterface {

    @Value("upload.path")
    private String uploadPath;

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientServiceInterfaceImpl(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }


    @Override
    public Iterable<Clients> getClients() {
        return clientsRepository.findAll();
    }

    @Override
    public Iterable<Clients> getClientByName(String name) {
        Iterable<Clients> clients;
        if (name != null && !name.isEmpty()) {
            clients = clientsRepository.findByName(name);
        } else {
            clients = getClients();
        }
        return clients;
    }

    @Override
    public Clients getClientById(Long id) {
        return clientsRepository.findClientsById(id);
    }

    @Override
    public void createClient(String name, String address, MultipartFile file) throws IOException {

        Clients client = new Clients();
        client.setName(name);
        client.setAddress(address);

        // кусок кода работы с файлом
        downloadFile(file, client);
        clientsRepository.save(client);

    }

    private void downloadFile(MultipartFile file, Clients client) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            client.setFilename(resultFilename);
        }
        // создаем клиента, обновляем список и отправляем его на страницу
    }

    @Override
    public Clients uploadClient(Clients clients, String name, String address, String mail) throws IOException {
        Clients client = clientsRepository.findClientsById(clients.getId());
        if (name == null || !name.isEmpty())
            client.setName(name);
        if (address == null || !address.isEmpty())
            client.setAddress(address);
        if (mail == null || !mail.isEmpty())
            client.setMail(mail);
//            downloadFile(file, client);
        clientsRepository.save(client);
        return client;
    }

    @Override
    public void deleteClient(Long id) {
        clientsRepository.deleteById(id);
    }


}
