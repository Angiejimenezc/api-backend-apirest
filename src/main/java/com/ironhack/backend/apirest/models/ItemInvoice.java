package com.ironhack.backend.apirest.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "invoices_items")
public class ItemInvoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="product_id")
    private Product product;   // producto que se va a vender


    public ItemInvoice() {
    }

    public ItemInvoice(Long id, String description, Integer quantity, Double unitPrice, Double totalPrice) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return quantity.doubleValue() * product.getPrice();
    }

    @Override
    public String toString() {
        return "ItemInvoice{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +

                '}';
    }
}
