package com.example.khanhtqt.service.admin;

import com.example.khanhtqt.config.ModelMapperConfig;
import com.example.khanhtqt.dto.CategoryDto;
import com.example.khanhtqt.entity.Category;
import com.example.khanhtqt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminCategoryService{
    @Autowired
    private ModelMapperConfig modelMapperConfig;
    @Autowired
    private CategoryRepository categoryRepository;

   public Page<CategoryDto> getAll(int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        return categoryRepository.findAll(pageable).map(this::convertToDto);
    }
    public void delete(Long id){
       categoryRepository.deleteById(id);
    }

    public CategoryDto getOne(Long id){
       Category category=categoryRepository.findById(id).orElseThrow(()-> new RuntimeException() );
       return convertToDto(category);
    }

    public void saveOrUpdate(Category category){
       categoryRepository.save(category);
    }





    private CategoryDto convertToDto(Category category) {
        return modelMapperConfig.modelMapper().map(category, CategoryDto.class);
    }
}
