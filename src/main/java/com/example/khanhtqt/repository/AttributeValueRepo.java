package com.example.khanhtqt.repository;

import com.example.khanhtqt.dto.AttributeValueDto;
import com.example.khanhtqt.entity.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AttributeValueRepo extends JpaRepository<AttributeValue,Long> {
    @Query("SELECT av FROM AttributeValue av WHERE av.attribute.name = 'Color'")
    List<AttributeValue> findAllColors();

    @Query("SELECT av FROM AttributeValue av WHERE av.attribute.name = 'Size'")
    List<AttributeValue> findAllSizes();

    @Query("SELECT av FROM AttributeValue av WHERE av.attribute.name = 'Material'")
    List<AttributeValue> findAllMaterial();
}
