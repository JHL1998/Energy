package com.big407.energy.vo;

import com.big407.energy.model.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldVO {
    private int code;
    private String msg;
    private int count;
    private List<Field> data;
}
