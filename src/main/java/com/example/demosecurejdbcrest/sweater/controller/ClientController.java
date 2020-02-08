package com.example.demosecurejdbcrest.sweater.controller;

import com.example.demosecurejdbcrest.sweater.entity.Clients;
import com.example.demosecurejdbcrest.sweater.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ClientController {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientController(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @GetMapping("/")
    public String getClients(Map<String, Object> model) {
        Iterable<Clients> clients = clientsRepository.findAll();
        model.put("clients", clients);
        return "index";
    }

    @PostMapping("/index")
    public String createClient(
            @RequestParam String name,
            @RequestParam String address,
            Map<String, Object> model
    ) {
        Clients client = new Clients().setName(name).setAddress(address);
        clientsRepository.save(client);

        Iterable<Clients> clients = clientsRepository.findAll();
        model.put("clients", clients);

        return "index";
    }

    @PostMapping("findClient")
    public String findClient(@RequestParam String name, Map<String, Object> model) {
        Iterable<Clients> clients;
        if (name != null && !name.isEmpty()){
            clients = clientsRepository.findByName(name);
        }else {
            clients = clientsRepository.findAll();
        }
        model.put("clients",clients);
        return "index";
    }
}
