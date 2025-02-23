package com.example.khanhtqt.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String image;
    private Integer stock;
    private LocalDateTime createdAt;
    private String sku;
    private List<ProductAttributeDto> productAttributes;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String description, BigDecimal price, String image, Integer stock, LocalDateTime createdAt, String sku, List<ProductAttributeDto> productAttributes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.stock = stock;
        this.createdAt = createdAt;
        this.sku = sku;
        this.productAttributes = productAttributes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<ProductAttributeDto> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(List<ProductAttributeDto> productAttributes) {
        this.productAttributes = productAttributes;
    }
}
