package com.ironhack.backend.apirest.controller;

import com.ironhack.backend.apirest.models.Client;
import com.ironhack.backend.apirest.models.Invoice;
import com.ironhack.backend.apirest.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private IClientService clientService;


    @GetMapping("/invoice/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice show(@PathVariable Long id) {
        return clientService.findInvoiceById(id);
    }

    @DeleteMapping("/invoice/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clientService.deleteInvoiceById(id);
    }
    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice create(@RequestBody Invoice invoice) {
        return clientService.saveInvoice(invoice);
    }

}