package com.ironhack.backend.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {  // implements Serializable to be able to send it as a JSON object
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String observation;
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date createAt;
/*
   @PrePersist   // se llama a este método antes de guardar la entidad en la base de datos
    public void prePersist() {
       this.createAt = new Date();
   }
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Client client;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<ItemInvoice> items = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(String description, String observation, Date createAt, Client client) {
        this.description = description;
        this.observation = observation;
        this.createAt = createAt;
        this.client = client;
        this.items = new ArrayList<>();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ItemInvoice> getItems() {
        return items;
    }

    public void setItems(List<ItemInvoice> items) {
        this.items = items;
    }

    public Double getTotal(){  // getTotal() is a method that calculates the total of the invoice
        Double total = 0.0;
        for (ItemInvoice item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
