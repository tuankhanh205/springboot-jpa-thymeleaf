package com.example.khanhtqt.controler.admin;

import com.example.khanhtqt.dto.CategoryDto;
import com.example.khanhtqt.service.admin.AdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminCategory {
    @Autowired
    private AdminCategoryService adminCategoryService;
    @GetMapping("/admin/category")
    public String getAll(@RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "5") int size,
                         Model model){
        Page<CategoryDto> page1=adminCategoryService.getAll(page,size);
        model.addAttribute("categorys",page1.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",page1.getTotalPages());
        System.out.println(page1);
        return "admin/views/category/category";
    }
}
