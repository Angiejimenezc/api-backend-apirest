package com.ironhack.backend.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min =4 , max = 50)
    private String name;
    @NotEmpty
    private String surname;
    @Email
    private String email;

    @NotNull(message = "Date cannot be null")
    @Column(name= "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private String photo;

    @JsonIgnore
    @OneToMany (mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Invoice> invoices;

    public Client() {
    }


    public Client(String name, String surname, String email, Date createAt) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.createAt = createAt;
        this.photo = "";
        this.invoices = new ArrayList<>();
    }

    public List<Invoice> getInvoice() {
        return invoices;
    }

    public void setInvoice(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
