package com.ironhack.backend.apirest.service;


import com.ironhack.backend.apirest.models.Client;

import java.util.List;

public interface IClientService {

    public List<Client> findAll();
    public Client findById(Long id);
    public Client save(Client client);
    public void delete(Long id);


}


