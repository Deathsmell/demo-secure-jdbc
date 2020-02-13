package com.example.demosecurejdbcrest.sweater.controller;

import com.example.demosecurejdbcrest.sweater.entity.Clients;
import com.example.demosecurejdbcrest.sweater.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class ClientController {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientController(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @Value("${upload.path}")
    private String uploadPath;

    @RequestMapping("/main")
    public String main (){
        return "main";
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
            Map<String, Object> model,
            @RequestParam ("file") MultipartFile file
    ) throws IOException {
        Clients client = new Clients(name, address);
        // кусок кода работы с файлом
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
