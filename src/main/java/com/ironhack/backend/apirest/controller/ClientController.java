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
    // Upload Photo
    @CrossOrigin
    @PostMapping("/clients/upload")
    //ResponseEntity
    public ResponseEntity<?> upload(@RequestParam ("file") MultipartFile file, @RequestParam ("id") Long id) {
       Map<String, Object> response = new HashMap<>();
        //Obtenemos el cliente a partir del id
        Client client = clientService.findById(id);
        //Valido si es distinto
        if(!file.isEmpty()){
        //Generamos un nombre aleatorio para el fichero con UUID
         String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename().replace(" "," ");
        //Generamos la ruta del fichero y resolvemos
         Path rutaFileName = Paths.get("uploads").resolve(fileName).toAbsolutePath();
        //Guardamos el fichero en la ruta
         File fileNameFile = rutaFileName.toFile();
        try {
            Files.copy(file.getInputStream(), rutaFileName);
        } catch (IOException e) {
        //Si hay un error, mostramos mensaje de error
            response.put("message", "Error al subir el fichero" + fileName);
            return new ResponseEntity<String>("Error al subir el fichero", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //Guardamos el nombre del fichero en el cliente
            client.setPhoto(fileName);
        //Guardamos el cliente
            clientService.save(client);
        //Guardamos el cliente en el mapa de respuesta
            response.put("client", client);
            response.put("message", "Has subido correctamete la imagen: " + fileName); //Guardamos el mensaje en el mapa de respuesta
        }
        return new ResponseEntity<Map<String,Object>>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/clients/upload/{id}")
    public ResponseEntity<?> getPhoto(@PathVariable Long id) {
        Client client = clientService.findById(id);
        String fileName = client.getPhoto();
        Path rutaFileName = Paths.get("src/main/resources/static/img").resolve("user.webp").toAbsolutePath();
        File fileNameFile = rutaFileName.toFile();
        if(fileNameFile.exists()){
            return ResponseEntity.ok(fileNameFile);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
