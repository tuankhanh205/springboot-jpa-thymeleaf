package com.example.khanhtqt.controler.admin;

import com.example.khanhtqt.dto.CategoryDto;
import com.example.khanhtqt.entity.Category;
import com.example.khanhtqt.service.admin.AdminCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/admin/category/delete/{id}")
    public String delete(@PathVariable ("id") Long id){
        adminCategoryService.delete(id);
        return "redirect:/admin/category";
    }
    @GetMapping("/admin/category/showadd")
    public String showAdd(Model model){
        model.addAttribute("category",new Category());
        return"admin/views/category/newCategory";
    }
    @PostMapping("/admin/category/add")
    public String add(@Valid @ModelAttribute ("category") Category category, BindingResult bindingResult){
       adminCategoryService.saveOrUpdate(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/showupdate/{id}")
    public String showAdd(@PathVariable ("id") Long id, Model model){
        model.addAttribute("category",adminCategoryService.getOne(id));
        return "admin/views/category/updateCategory";
    }

}
