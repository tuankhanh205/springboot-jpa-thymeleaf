package com.example.khanhtqt.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryCon {
    @GetMapping("/category")
    public String ShowCate(){
        return "views/category";
    }
}
