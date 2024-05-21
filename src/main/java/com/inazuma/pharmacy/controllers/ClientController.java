package com.inazuma.pharmacy.controllers;

import com.inazuma.pharmacy.dtos.ClientDto;
import com.inazuma.pharmacy.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping
    public ClientDto create(@RequestBody ClientDto clientDto){
        return clientService.createClient(clientDto);
    }

    @GetMapping
    public List<ClientDto> listAll(){
        return clientService.listAll();
    }

    @GetMapping(path = "/users/{id}")
    public ClientDto findClientById(@PathVariable Long id){
        return clientService.findById(id);
    }

    @GetMapping(path = "/{name}")
    public ClientDto findByName(@PathVariable String name){
        return clientService.findClientByName(name);
    }
}
