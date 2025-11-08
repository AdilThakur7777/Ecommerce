package org.example.microservices_spring.controller;

import lombok.RequiredArgsConstructor;
import org.example.microservices_spring.dto.CartItemRequest;
import org.example.microservices_spring.model.CartItem;
import org.example.microservices_spring.repository.CartItemRepository;
import org.example.microservices_spring.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<String> addToCart(
            @RequestHeader("X-User-ID")String userId,
            @RequestBody CartItemRequest request){
        if(!cartService.addToCart(userId,request))
        {
            return ResponseEntity.badRequest().body("Product out of Stock or User not found or Product not found!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
