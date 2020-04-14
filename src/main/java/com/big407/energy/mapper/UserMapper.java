package com.big407.energy.mapper;

import com.big407.energy.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username,password,name,tel,email,gmt_create,gmt_modified) " +
            "values(#{username},#{password},#{name},#{tel},#{email},#{gmtCreate},#{gmtModified})")
    void addUser(User user);

    @Select("select * from user where id=#{id}")
    User getById(Long id);

    @Select("select * from user where username=#{username} and password= #{password}")
    User login(String username,String password);

    @Update("update user set token=#{token} where id=#{id}")
    void addToken( Long id,String token);

    @Select("select * from user where token=#{token}")
    User findByToken(String token);

}
