package org.example.microservices_spring.repository;

import org.example.microservices_spring.model.CartItem;
import org.example.microservices_spring.model.Product;
import org.example.microservices_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByUserAndProduct(User user, Product product);

}
