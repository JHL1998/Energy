package com.big407.energy.controller;

import com.big407.energy.mapper.FieldMapper;
import com.big407.energy.vo.FieldVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FiledController {

    @Autowired
    private FieldMapper fieldMapper;

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }


    @GetMapping("/findAllField")
    @ResponseBody
    public FieldVO findAllField(){
        return new FieldVO(0,"",fieldMapper.count(),fieldMapper.findAll());
    }


}
