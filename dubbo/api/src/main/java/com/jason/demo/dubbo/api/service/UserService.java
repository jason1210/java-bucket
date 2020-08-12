package com.jason.demo.dubbo.api.service;

import com.jason.demo.dubbo.api.model.User;

/**
 * @author: jason
 * @Date: 2020-08-11
 */
public interface UserService {
    User findUserById(Integer id);
}