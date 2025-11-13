package com.example.e_commerce_api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Product product;
    private float price;
    private float qty;
    private float discount;
    private String status;
    private int orderId;
}
