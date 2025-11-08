package org.example.microservices_spring.dto;

import lombok.Data;
import org.example.microservices_spring.model.UserRole;
@Data
public class UserRequest {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private UserRole role;
    private AddressDTO address;
}
