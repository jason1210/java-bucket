package com.jason.demo.shardingsphere.model;

import lombok.Data;

/**
 * @author: jason
 * @Date: 2020-08-13
 */
@Data
public class Address {
    private Long id;
    private String code;
    private String name;
    private String pid;
    private Integer type;
    private Integer lit;
}
