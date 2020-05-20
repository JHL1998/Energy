package com.big407.energy.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class User {
    //唯一标识
    private Long id;
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @Length(min=11,max=11,message = "电话号码必须为11位")
    private String tel;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "邮箱不能为空")
    private String email;
    private Long gmtCreate;
    private Long gmtModified;


}
