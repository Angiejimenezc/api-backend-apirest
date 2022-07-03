package com.ironhack.backend.apirest.controller;


import com.ironhack.backend.apirest.models.Client;
import com.ironhack.backend.apirest.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @CrossOrigin
    @GetMapping("/clients")
    public List<Client> index(){
    return clientService.findAll();
}

    @CrossOrigin
    @GetMapping("/clients/{id}")
    @ResponseStatus (HttpStatus.OK)
    public Client show(@PathVariable Long id){
        return clientService.findById(id);
    }

    @CrossOrigin
    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client){
        client.setCreateAt(new Date());
        return clientService.save(client);
    }
    @CrossOrigin
    @PutMapping("/clients/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public Client update(@RequestBody Client client, @PathVariable Long id){
        Client clientToUpdate = clientService.findById(id);
        clientToUpdate.setName(client.getName());
        clientToUpdate.setSurname(client.getSurname());
        clientToUpdate.setEmail(client.getEmail());
        return clientService.save(clientToUpdate);
    }
    @CrossOrigin
    @DeleteMapping("/clients/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }

}
