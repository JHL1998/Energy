package com.big407.energy.controller;

import com.big407.energy.mapper.UserMapper;
import com.big407.energy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;



    @PostMapping("/login")
    public String login(@RequestParam(name="username",required = false) String username,
                        @RequestParam(name="password",required = false)String password,
                        HttpServletResponse response){
           User user=userMapper.findByPassword(username,password);
           if(user!=null){
               //登录成功
               String token= UUID.randomUUID().toString();
               //将自定义的token写入cookie
               userMapper.addToken(user.getId(),token);
               response.addCookie(new Cookie("token",token));

               return "redirect:/profile";
           }else{
               //退回到登录页面
               return "redirect:/";
           }


    }
}
