package com.example.khanhtqt.repository;

import com.example.khanhtqt.entity.Attribute;
import com.example.khanhtqt.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductAttributeRepo extends JpaRepository<ProductAttribute,Long> {
    @Query("SELECT s FROM ProductAttribute s WHERE s.product.id = :id")
    public List<ProductAttribute> findByProductId(@Param("id") Long id);
}
