package com.big407.energy.service;

import com.big407.energy.mapper.UserMapper;
import com.big407.energy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void create(User user) {

        if (userMapper.getById(user.getId()) == null) {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());

            userMapper.addUser(user);
        }

    }

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username,String password){

         User user=userMapper.login(username,password);
         return user;

    }

    /**
     * 添加token
     * @param id
     * @param token
     */
    public void addToken(Long id,String token){
        userMapper.addToken(id,token);

    }


    public User findByToken(String token){
       return  userMapper.findByToken(token);
    }




}
