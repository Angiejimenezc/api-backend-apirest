package com.ironhack.backend.apirest.models;

import javax.persistence.*;
import java.io.Serializable;


    @Entity
    @Table(name="roles")
    public class Role implements Serializable {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;

        @Column(unique=true, length=20)
        private String name;

        public Role() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
