package com.big407.energy.controller;

import com.big407.energy.mapper.GithubMapper;
import com.big407.energy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private GithubMapper githubMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/view")
    public String view(Model model){

        model.addAttribute("stationNum",githubMapper.countGithubUser()+userMapper.countUser());

        return "view";
    }


}
