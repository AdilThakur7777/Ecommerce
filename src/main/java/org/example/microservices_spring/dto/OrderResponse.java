package org.example.microservices_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.microservices_spring.model.OrderStatus;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private List<OrderItemDTO> items;
    private LocalDateTime createdAt;
}
