package com.example.khanhtqt.service.admin;

import com.example.khanhtqt.config.ModelMapperConfig;
import com.example.khanhtqt.dto.CategoryDto;
import com.example.khanhtqt.entity.Category;
import com.example.khanhtqt.repository.CategoryRepository;
import com.example.khanhtqt.service.common.ProductAdminClientIlm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.module.Configuration;
import java.util.stream.Collectors;

@Service
public class AdminCategoryService extends ProductAdminClientIlm {
    @Autowired
    private ModelMapperConfig modelMapperConfig;
    @Autowired
    private CategoryRepository categoryRepository;

   public Page<CategoryDto> getAll(int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        return categoryRepository.findAll(pageable).map(this::convertToDto);
    }

    private CategoryDto convertToDto(Category category) {
        return modelMapperConfig.modelMapper().map(category, CategoryDto.class);
    }
}
