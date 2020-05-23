package com.big407.energy.service;

import com.big407.energy.mapper.GithubMapper;
import com.big407.energy.model.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubUserService {

    @Autowired
    private GithubMapper mapper;

    public void createOrUpdate(GithubUser githubUser) {
        GithubUser user = mapper.findById(githubUser.getAccountId());
        if (user == null) {
            githubUser.setGmtCreate(System.currentTimeMillis());
            githubUser.setGmtModified(githubUser.getGmtCreate());

            mapper.create(githubUser);
        } else {
            user.setGmtModified(System.currentTimeMillis());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            user.setName(githubUser.getName());
            user.setToken(githubUser.getToken());
            mapper.update(user);

        }

    }
}
