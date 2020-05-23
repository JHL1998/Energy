package com.big407.energy.mapper;

import com.big407.energy.model.Field;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FieldMapper {

    @Select("select * from field")
    List<Field> findAll();

    @Select("select count(*) from field")
    int count();
}
