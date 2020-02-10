package com.example.demosecurejdbcrest.sweater.controller;

import com.example.demosecurejdbcrest.security.dao.User;
import com.example.demosecurejdbcrest.sweater.entity.Clients;
import com.example.demosecurejdbcrest.sweater.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ClientController {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientController(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @GetMapping("/")
    public String rootPage (){
        return "index";
    }

    @GetMapping("/index")
    public String getClients(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        Iterable<Clients> clients = clientsRepository.findAll();

        if (name != null && !name.isEmpty()){
            clients = clientsRepository.findByName(name);
        }else {
            clients = clientsRepository.findAll();
        }
        model.addAttribute("name", name);
        model.addAttribute("clients", clients);
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

    @GetMapping("/delete/{id}")
    public String deleteClient (@PathVariable ("id") Long id){
        clientsRepository.deleteById(id);
        return "redirect:/index";
    }
}
