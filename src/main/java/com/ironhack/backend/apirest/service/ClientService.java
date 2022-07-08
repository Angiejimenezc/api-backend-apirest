package com.ironhack.backend.apirest.service;

import com.ironhack.backend.apirest.models.Client;
import com.ironhack.backend.apirest.models.Invoice;
import com.ironhack.backend.apirest.models.Product;
import com.ironhack.backend.apirest.repository.ClientRepository;
import com.ironhack.backend.apirest.repository.InvoiceRepository;
import com.ironhack.backend.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null); // if not found, return null
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public Invoice findInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoiceById(Long id) {
        invoiceRepository.deleteById(id);

    }

    @Override
    public List<Product> findProductByName(String term) {
        return productRepository.findByNameContainingIgnoreCase(term); // ignore case

    }
}
