package com.example.khanhtqt.service.admin;

import com.example.khanhtqt.entity.AttributeValue;
import com.example.khanhtqt.repository.AttributeValueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminAttributeValueService {
    @Autowired
    private AttributeValueRepo attributeValueRepo;

    public List<AttributeValue> getColor(){
        return attributeValueRepo.findAllColors();
    }
    public List<AttributeValue> getSize(){
        return attributeValueRepo.findAllSizes();
    }
    public List<AttributeValue> getMaterial(){
        return attributeValueRepo.findAllMaterial();
    }
}
