package com.jason.demo.shardingsphere.model;

import lombok.Data;

import java.util.Date;

/**
 * @author: jason
 * @Date: 2020-08-13
 */
@Data
public class User {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private Integer cityId;
    private Date createTime;
    private Integer sex;
}
