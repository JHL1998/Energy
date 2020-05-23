package com.big407.energy.model;

import lombok.Data;

@Data
public class GithubUser {
    private Long id;
    private String name;
    private String  accountId;
    private String token;
    private String avatarUrl;
    private Long  gmtCreate;
    private Long gmtModified;


}
