package com.example.e_commerce_api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String imageUrl;
    @ManyToOne
    private Category category;
    private float cost;
    private float price;
    private float qtyOnHand;
    private String status;
}
