package com.example.khanhtqt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class tet {
    @GetMapping("/tet")
    public String tet(){
        return "layout/main";
    }
}
