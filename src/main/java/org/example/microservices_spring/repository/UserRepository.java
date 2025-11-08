package org.example.microservices_spring.repository;

import org.example.microservices_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//we can use crudRepository but jpaRepository is better and have more methods
//build in jpa
@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
}
