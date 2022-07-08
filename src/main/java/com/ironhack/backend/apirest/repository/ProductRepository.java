package com.ironhack.backend.apirest.repository;

import com.ironhack.backend.apirest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByName(String name);  //term to search for
    public List<Product> findByNameContainingIgnoreCase(String name); //term to search for
    public List<Product> findByNameStartingWithIgnoreCase(String name); //term to search for
}

