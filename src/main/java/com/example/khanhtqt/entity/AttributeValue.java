package com.example.khanhtqt.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "attribute_values")

public class AttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute; // Thuộc tính cha (COLOR, SIZE, MATERIAL)

    @Column(nullable = false, unique = true)
    private String name; // Giá trị cụ thể, VD: "Đỏ", "M", "Cotton"

    @OneToMany(mappedBy = "attributeValue", cascade = CascadeType.ALL)
    private List<ProductAttribute> productAttributes;

    public AttributeValue() {
    }

    public AttributeValue(Long id, Attribute attribute, String name, List<ProductAttribute> productAttributes) {
        this.id = id;
        this.attribute = attribute;
        this.name = name;
        this.productAttributes = productAttributes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }
}
