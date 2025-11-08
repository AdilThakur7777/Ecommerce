package org.example.microservices_spring.controller;

import lombok.RequiredArgsConstructor;
import org.example.microservices_spring.dto.OrderResponse;
import org.example.microservices_spring.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestHeader ("X-User-ID")String userId) {
       return orderService.createOrder(userId)
               .map(orderResponse->
                       new ResponseEntity<>(orderResponse,HttpStatus.CREATED))
               .orElse(ResponseEntity.notFound().build());
    }
}
