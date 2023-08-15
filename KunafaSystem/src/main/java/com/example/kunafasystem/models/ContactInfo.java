package com.example.kunafasystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String phoneNumber;
    private String city;
    private String street;
    private long buildingNo;
    private String whatsAppNumber;
    private String instagramProfile;
    private String facebookProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public ContactInfo(String phoneNumber, String city, String street, long buildingNo, String whatsAppNumber, String instagramProfile, String facebookProfile, Customer customer) {
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.buildingNo = buildingNo;
        this.whatsAppNumber = whatsAppNumber;
        this.instagramProfile = instagramProfile;
        this.facebookProfile = facebookProfile;
        this.customer = customer;
    }

    //    Lombok is responsible for Setters & Getters
}
