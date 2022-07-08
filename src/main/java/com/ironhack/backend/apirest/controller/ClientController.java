package com.ironhack.backend.apirest.controller;
import com.ironhack.backend.apirest.models.Client;
import com.ironhack.backend.apirest.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @CrossOrigin
    @GetMapping("/clients")
    public List<Client> index() {
        return clientService.findAll();
    }

    @CrossOrigin
    @GetMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client show(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @CrossOrigin
    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@Valid @RequestBody Client client) {
           return clientService.save(client);
    }

    @CrossOrigin
    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client, @PathVariable Long id) {
        Client clientToUpdate = clientService.findById(id);
        clientToUpdate.setName(client.getName());
        clientToUpdate.setSurname(client.getSurname());
        clientToUpdate.setEmail(client.getEmail());
        return clientService.save(clientToUpdate);
    }

    @CrossOrigin
    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Client client = clientService.findById(id);
        clientService.delete(id);
    }
    @PostMapping("/clients/upload")
    public ResponseEntity<?> upload(@RequestParam ("file") MultipartFile file, @RequestParam ("id") Long id) {
       Map<String, Object> response = new HashMap<>();


        Client client = clientService.findById(id);  //Obtenemos el cliente a partir del id

        if(!file.isEmpty()){
         String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename(); //Generamos un nombre aleatorio para el fichero
         Path rutaFileName = Paths.get("uploads").resolve(fileName).toAbsolutePath(); //Generamos la ruta del fichero
         File fileNameFile = rutaFileName.toFile();
        try { //Guardamos el fichero en la ruta
            Files.copy(file.getInputStream(), rutaFileName);
        } catch (IOException e) {
            response.put("message", "Error al subir el fichero" + fileName); //Si hay un error, mostramos el error
            return new ResponseEntity<String>("Error al subir el fichero", HttpStatus.INTERNAL_SERVER_ERROR);
        }
            client.setPhoto(fileName); //Guardamos el nombre del fichero en el cliente
            clientService.save(client); //Guardamos el cliente
            response.put("client", client); //Guardamos el cliente en el mapa de respuesta
            response.put("message", "Has subido correctamete la imagen: " + fileName); //Guardamos el mensaje en el mapa de respuesta
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
