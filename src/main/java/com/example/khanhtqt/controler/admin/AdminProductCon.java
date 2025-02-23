package com.example.khanhtqt.controler.admin;

import com.example.khanhtqt.dto.ProductDto;
import com.example.khanhtqt.entity.Product;
import com.example.khanhtqt.service.admin.AdminAttributeValueService;
import com.example.khanhtqt.service.admin.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminProductCon {
    @Autowired
    private AdminProductService adminProductService;
    @Autowired
    private AdminAttributeValueService adminAttributeValueService;
    @GetMapping("/admin/product")
    public String getAll(@RequestParam(defaultValue = "0")int page,
                         @RequestParam(defaultValue = "5") int size, Model model){
       Page<ProductDto> products= adminProductService.getAll(page,size);
       model.addAttribute("products",products.getContent());
       model.addAttribute("totalPages",products.getTotalPages());
       model.addAttribute("currentPage",page);
        return "admin/views/product/product";
    }
    @GetMapping("/admin/product/showadd")
    public String showAdd(Model model){
    model.addAttribute("color",adminAttributeValueService.getColor());
    model.addAttribute("size",adminAttributeValueService.getSize());
    model.addAttribute("material",adminAttributeValueService.getMaterial());
    return"admin/views/product/newProduct";
    };

}
