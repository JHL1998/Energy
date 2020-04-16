package com.big407.energy.controller;

import com.big407.energy.model.User;
import com.big407.energy.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

     @Autowired
     private UserService userService;

         @GetMapping("/register")
      public String register(){



             return "register";
      }

      @PostMapping("/register")
      public  String doRegister( @RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String name,
                                 @RequestParam String tel,
                                 @RequestParam String email,
                                 Model model

                               ){

          model.addAttribute("username",username);
          model.addAttribute("password",password);
          model.addAttribute("name",name);
          model.addAttribute("tel", tel);
          model.addAttribute("email",email);
          if(StringUtils.isBlank(username)){
              model.addAttribute("error","用户名不能为空");
              return "register";
          }
          if(StringUtils.isBlank(password)){
              model.addAttribute("error","密码不能为空");
              return "register";
          }
          if(StringUtils.isBlank(name)){
              model.addAttribute("error","姓名不能为空");
              return "register";
          }

          if(tel.length()!=11||tel==null||tel==""){
              model.addAttribute("error","电话号码长度必须有效");
              return "register";
          }
          if(StringUtils.isBlank(email)){
              model.addAttribute("error","邮箱必须有效");
              return "register";
          }

          User user = new User();
          user.setUsername(username);
          user.setPassword(password);
          user.setName(name);
          user.setEmail(email);
          user.setTel(tel);

          userService.create(user);
             return "redirect:/";

      }
}
