package com.example.khanhtqt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "attributes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // VD: Color, Size, Material

    @Column(nullable = false)
    private String type; // VD: COLOR, SIZE, MATERIAL

    @OneToMany(mappedBy = "attribute")
    private List<ProductAttribute> productAttributes;
}
