package com.big407.energy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperationController {


    @GetMapping("/operation")
     public String operation(){
         return "operation";
     }


}
