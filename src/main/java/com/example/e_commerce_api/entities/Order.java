package com.example.e_commerce_api.entities;

import com.example.e_commerce_api.entities.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    private Date orderDate;
    private float amount;
    private float discount;
    private String status;
}
