package com.big407.energy.mapper;

import com.big407.energy.model.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    @Select("select * from  admin  where username=#{user} and password=#{password}")
     Admin login(String username,String password);

}
