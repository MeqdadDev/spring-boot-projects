package com.example.kunafasystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;

    @Enumerated(EnumType.STRING)
    private Status orderStatus;

    private Date timestamp;

    public Order(String type, Status orderStatus, HashMap<MenuItems, Integer> items, Date timestamp) {
        this.type = type;
        this.orderStatus = orderStatus;
        this.items = items;
        this.timestamp = timestamp;
    }

    public enum Status {
        PENDING,
        IN_PROGRESS,
        DONE,
        CANCELLED
    }
}
