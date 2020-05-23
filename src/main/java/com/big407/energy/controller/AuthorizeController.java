package com.big407.energy.controller;

import com.big407.energy.dto.AccessToken;
import com.big407.energy.model.GithubUser;
import com.big407.energy.provider.GithubProvider;
import com.big407.energy.service.GithubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private GithubUserService githubUserService;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = ("state")) String state,
                           HttpServletResponse response
    ) {
        AccessToken accessToken = new AccessToken();

        accessToken.setCode(code);
        accessToken.setRedirect_uri(redirectUri);
        accessToken.setClient_id(clientId);
        accessToken.setClient_secret(clientSecret);
        accessToken.setState(state);
        String accesstoken = githubProvider.getAccessToken(accessToken);
        GithubUser githubuser = githubProvider.getUser(accesstoken);
        if (githubuser != null && githubuser.getId() != null) {
            //登录成功
            GithubUser user = new GithubUser();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubuser.getName());
            user.setAccountId(String.valueOf(githubuser.getId()));
            user.setAvatarUrl(githubuser.getAvatarUrl());
            //这里插入数据库的过程就相当于写入Session
            githubUserService.createOrUpdate(user);
            //写入cookie
            response.addCookie(new Cookie("token", token));

            return "/login";

        } else {
            //登陆失败，重新登陆
            return "redirect:/";
        }

    }

}
