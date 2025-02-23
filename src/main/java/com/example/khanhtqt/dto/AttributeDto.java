package com.example.khanhtqt.dto;

import com.example.khanhtqt.entity.AttributeValue;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


public class AttributeDto {
    private Long id;


    private String name; // VD: Color, Size, Material


    private List<AttributeValue> attributeValues;

    public AttributeDto() {
    }

    public AttributeDto(Long id, String name, List<AttributeValue> attributeValues) {
        this.id = id;
        this.name = name;
        this.attributeValues = attributeValues;
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

    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }
}
