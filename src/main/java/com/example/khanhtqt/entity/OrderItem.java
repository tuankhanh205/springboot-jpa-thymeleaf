package com.example.khanhtqt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // Liên kết với Order
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // Liên kết với Product
    private Product product;

}
