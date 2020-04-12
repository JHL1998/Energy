package com.big407.energy.mapper;

import com.big407.energy.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username,password,name,tel,email,gmt_create,gmt_modified) " +
            "values(#{username},#{password},#{name},#{tel},#{email},#{gmtCreate},#{gmtModified})")
    void addUser(User user);

    @Select("select * from user where id=#{id}")
    User getById(Long id);

    @Select("select * from user where username=#{username} and password= #{password}")
    User findByPassword(String username,String password);

}