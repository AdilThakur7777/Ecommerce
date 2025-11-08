package org.example.microservices_spring.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.engine.spi.CascadeStyle;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "users")
  // create table for this class JPA will do this
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private UserRole role=UserRole.CUSTOMER;

    @OneToOne(cascade=CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="address_id", referencedColumnName = "id")
    private Address address;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime modifiedDate;
//
//    public User(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//    public User() {}
}
//Entities are POJO Plain Old Java Object's in JPA
//each instance is a row in JPA
// JPA entities are object that represent data in the relational database
// deafult constructor is needed to create the insatances of entity class during the retervial of data.
// default constructor is mandatory

