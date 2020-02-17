package com.example.demosecurejdbcrest.sweater.controller;

import com.example.demosecurejdbcrest.sweater.entity.Clients;
import com.example.demosecurejdbcrest.sweater.service.ClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class ClientController {

    private final ClientServiceInterface clientService;

    @Autowired
    public ClientController( ClientServiceInterface clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/main")
    public String main (){
        return "main";
    }

    @GetMapping("/index")
    public String getClients(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("clients", clientService.getClientByName(name));
        return "index";
    }

    @PostMapping("/index")
    public String createClient(
            @RequestParam String name,
            @RequestParam String address,
            Map<String, Object> model,
            @RequestParam ("file") MultipartFile file
    ) throws IOException {

        clientService.createClient(name, address, file);

        model.put("clients", clientService.getClients());

        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient (@PathVariable ("id") Long id){
        clientService.deleteClient(id);
        return "redirect:/index";
    }

    @GetMapping("/upload/{clients}")
    public String getClientInfo (@PathVariable Clients clients, Model model){
        Clients client = clientService.getClientById(clients.getId());
        model.addAttribute("client", client);
        return "uploadClient";
    }

    @PostMapping("/upload/{clients}")
    public String uploadClient (
            @PathVariable Clients clients,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String mail
//            @RequestParam String filename,
//            @RequestParam ("file") MultipartFile file
    ) throws IOException{
        clientService.uploadClient(clients,name, address, mail);
        return "redirect:/index";
    }
}
