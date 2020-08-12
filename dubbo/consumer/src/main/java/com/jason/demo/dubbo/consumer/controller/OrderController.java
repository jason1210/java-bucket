package com.jason.demo.dubbo.consumer.controller;

import com.jason.demo.dubbo.api.model.User;
import com.jason.demo.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jason
 * @Date: 2020-08-12
 */
@RestController
public class OrderController {

    @Reference  //注入要调用的服务
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        //调用服务
        User user = userService.findUserById(id);
        return user;
    }

}