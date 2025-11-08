package org.example.microservices_spring.dto;

import lombok.Data;
import org.example.microservices_spring.model.UserRole;
@Data
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
