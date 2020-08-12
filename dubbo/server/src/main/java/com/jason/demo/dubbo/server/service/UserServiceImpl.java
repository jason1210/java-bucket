package com.jason.demo.dubbo.server.service;

import com.jason.demo.dubbo.api.model.User;
import com.jason.demo.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author: jason
 * @Date: 2020-08-12
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("chy");
        return user;
    }
}
