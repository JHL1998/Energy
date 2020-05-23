package com.big407.energy.provider;

import com.alibaba.fastjson.JSON;
import com.big407.energy.dto.AccessToken;
import com.big407.energy.model.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccessToken accessToken){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        //将accessToken对象转换为json对象
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessToken));
        Request request = new Request.Builder()
                //第二步
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string=response.body().string();
            //先通过"&"号分割拿到第一个元素，然后通过"="分割 拿到第二个元素
            String token = string.split("&")[0].split("=")[1];
            return token;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //通过accessToken获取用户信息
    public GithubUser  getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string=response.body().string();
            //把上述String自动转成Java的类对象
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
