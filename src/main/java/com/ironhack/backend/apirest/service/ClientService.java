package com.ironhack.backend.apirest.service;

import com.ironhack.backend.apirest.models.Client;
import com.ironhack.backend.apirest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService implements IClientService {

@Autowired
private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }
}
