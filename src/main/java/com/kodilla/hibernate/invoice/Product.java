package com.kodilla.hibernate.invoice;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "NAME")
    private String name;

    public Product() {}

    public Product(String name) {
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }
}
