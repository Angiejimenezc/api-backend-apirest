package com.ironhack.backend.apirest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private String email;
    @Column(name= "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    public Client() {
    }

    public Client(String name, String surname, String email, Date createAt) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.createAt = createAt;
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
