package com.big407.energy.controller;

import com.big407.energy.model.User;
import com.big407.energy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

     @Autowired
     private UserService userService;

         @GetMapping("/register")
      public String register(User user, HttpServletRequest request){



             return "register";
      }

      @PostMapping("/register")
      public  String doRegister(@RequestParam String username,
                                @RequestParam String password,
                                @RequestParam String name,
                                @RequestParam String tel,
                                @RequestParam String email,
                                HttpServletRequest request,
                                Model model){

          User user = new User();
          user.setUsername(username);
          user.setPassword(password);
          user.setName(name);
          user.setEmail(email);
          user.setTel(tel);

          userService.create(user);
             return "register";

      }
}
