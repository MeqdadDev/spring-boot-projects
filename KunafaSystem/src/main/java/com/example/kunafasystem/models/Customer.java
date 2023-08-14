package com.example.kunafasystem.models;

import com.example.kunafasystem.Dto.ContactInfoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private long id;
    private String firstName;
    private String lastName;

}
