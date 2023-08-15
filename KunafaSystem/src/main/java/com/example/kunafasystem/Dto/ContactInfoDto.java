package com.example.kunafasystem.Dto;

import lombok.Data;

@Data
public class ContactInfoDto {
    private long id;
    private String phoneNumber;
    private String city;
    private String street;
    private long buildingNo;
    private String whatsAppNumber;
    private String instagramProfile;
    private String facebookProfile;

    private CustomerDto customer;
}
