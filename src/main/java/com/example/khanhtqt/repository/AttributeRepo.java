package com.example.khanhtqt.repository;

import com.example.khanhtqt.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepo extends JpaRepository<Attribute,Long> {

}
