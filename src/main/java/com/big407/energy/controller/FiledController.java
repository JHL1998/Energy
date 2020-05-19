package com.big407.energy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FiledController {

    @GetMapping("/field")
    public String field(){
        return "field";
    }
}
