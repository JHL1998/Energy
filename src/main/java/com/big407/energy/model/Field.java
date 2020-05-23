package com.big407.energy.model;

import lombok.Data;

import java.util.Date;

@Data
public class Field {
    private Long id;
    private String name;
    private Integer capacity;
    private  Integer load;
    private Long electric;
    private Date time;
}
