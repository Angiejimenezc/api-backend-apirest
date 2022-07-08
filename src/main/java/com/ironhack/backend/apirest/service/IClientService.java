package com.ironhack.backend.apirest.service;
import com.ironhack.backend.apirest.models.Client;
import com.ironhack.backend.apirest.models.Invoice;
import com.ironhack.backend.apirest.models.Product;


import java.util.List;

public interface IClientService {

    public List<Client> findAll();
    public Client findById(Long id);
    public Client save(Client client);
    public void delete(Long id);
    public Invoice findInvoiceById(Long id);
    public Invoice saveInvoice(Invoice invoice);
    public void deleteInvoiceById(Long id);
    public List<Product> findProductByName(String term);


}


