package com.big407.energy.controller;

import com.big407.energy.mapper.UserMapper;
import com.big407.energy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;


      @GetMapping("/login")
      public String login(@RequestParam(value="username",required = false) String username,
                          @RequestParam( value="password",required = false) String password,
                          HttpServletRequest request){

          User user = userMapper.findByPassword(username, password);
          if(user!=null){
              //登录成功
              if(user.getStatus()==0){
                  //普通用户
                  request.getSession().setAttribute("user",user);
                  return "profile";
              }else{
                  //管理员用户
                  request.getSession().setAttribute("admin",user);
                  return "adminProfile";
              }

          }else{
              //登录失败，跳转回登录界面

              return "redirect:/index";
          }



      }
}
