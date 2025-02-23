package com.example.khanhtqt.service.admin;

import com.example.khanhtqt.config.ModelMapperConfig;
import com.example.khanhtqt.dto.ProductDto;
import com.example.khanhtqt.entity.Product;

import com.example.khanhtqt.entity.ProductAttribute;
import com.example.khanhtqt.repository.AttributeRepo;
import com.example.khanhtqt.repository.ProductAttributeRepo;
import com.example.khanhtqt.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminProductService{
    @Autowired
    private ProductAttributeRepo productAttributeRepo;

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapperConfig modelMapperConfig;

    public Page<ProductDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDto>productDtos=productRepository.findAll(pageable).map(this::convertDto);
        productDtos.forEach(productDto -> {
            Product product = productRepository.findById(productDto.getId()).orElse(null);
            if (product != null) {
                productDto.setSku(generateSku(product)); // Gán SKU vào ProductDto
            }
        });
        return productDtos;
    }

//    public ProductDto create(Product product){
//        productRepository.save(product);
//
//
//
//    }

    public String generateSku(Product product){
       StringBuilder stringBuilder=new StringBuilder();
       stringBuilder.append(product.getName().toUpperCase());
        List<ProductAttribute> attributes = productAttributeRepo.findByProductId(product.getId());
        for(ProductAttribute attribute : attributes){
            stringBuilder.append("-").append(attribute.getAttributeValue().getName().toUpperCase());
        }
        return stringBuilder.toString();
    }

    public  ProductDto convertDto(Product product){
        return modelMapperConfig.modelMapper().map(product, ProductDto.class);
    }

}
