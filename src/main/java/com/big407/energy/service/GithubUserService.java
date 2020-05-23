package com.big407.energy.service;

import com.big407.energy.mapper.GithubMapper;
import com.big407.energy.model.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubUserService {

    @Autowired
    private GithubMapper mapper;

    public void createOrUpdate(GithubUser githubUser){
        GithubUser user = mapper.findById(githubUser.getAccountId());
         if(user==null){
             user.setGmtCreate(System.currentTimeMillis());
             user.setGmtModified(user.getGmtCreate());
             mapper.create(githubUser);
         }else{
             GithubUser newUser= new GithubUser();
            newUser.setGmtModified(System.currentTimeMillis());
             newUser.setAvatarUrl(user.getAvatarUrl());
             newUser.setToken(user.getToken());
             newUser.setName(user.getName());
             mapper.update(newUser,user.getAccountId());

         }

    }
}
