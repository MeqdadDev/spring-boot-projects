package com.example.kunafasystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;
    private String preferences;
    private Boolean availability;

    public MenuItems(String type, String preferences, Boolean availability) {
        this.type = type;
        this.preferences = preferences;
        this.availability = availability;
    }

    public MenuItems(long id, String type, Boolean availability) {
        this.id = id;
        this.type = type;
        this.availability = availability;
    }
}
