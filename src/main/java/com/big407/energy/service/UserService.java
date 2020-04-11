package com.big407.energy.service;

import com.big407.energy.mapper.UserMapper;
import com.big407.energy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

      @Autowired
      private UserMapper userMapper;

       public void create(User user){

           if(userMapper.getById(user.getId())==null){
               user.setGmtCreate(System.currentTimeMillis());
               user.setGmtModified(user.getGmtCreate());

               userMapper.addUser(user);
           }
           //表示该用户已存在


       }



}
