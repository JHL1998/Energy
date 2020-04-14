package com.big407.energy.controller;

import com.big407.energy.model.User;
import com.big407.energy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping("/")
    public String loginPage(){

        return "index";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param session
     * @param response
     * @param attributes
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam(name="username",required = false) String username,
                        @RequestParam(name="password",required = false)String password,
                        HttpSession session,
                        HttpServletResponse response,
                        RedirectAttributes attributes){
           User user=userService.login(username,password);
           if(user!=null){
               //登录成功
               session.setAttribute("user",user);
               String token= UUID.randomUUID().toString();
               //将自定义的token写入cookie
               userService.addToken(user.getId(),token);
               response.addCookie(new Cookie("token",token));


               return "/profile";
           }else{
               //退回到登录页面
               attributes.addFlashAttribute("message","用户名和密码错误");


               return "redirect:/";
           }


    }

    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){

    session.removeAttribute("user");
           return "redirect:/";

    }
}
