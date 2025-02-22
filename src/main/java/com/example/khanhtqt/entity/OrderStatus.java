package com.example.khanhtqt.entity;



public enum OrderStatus {
    PENDING,      // Chờ xác nhận
    CONFIRMED,    // Đã xác nhận
    SHIPPED,      // Đang giao hàng
    DELIVERED,    // Đã giao
    CANCELLED     // Đã hủy
}
