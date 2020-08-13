package com.jason.demo.shardingsphere.controller;

import com.jason.demo.shardingsphere.mapper.UserMapper;
import com.jason.demo.shardingsphere.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: jason
 * @Date: 2020-08-13
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user/save")
    public String save() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setCityId(1 % 2 == 0 ? 1 : 2);
            user.setCreateTime(new Date());
            user.setSex(i % 2 == 0 ? 1 : 2);
            user.setPhone("11111111" + i);
            user.setEmail("xxxxx");
            user.setCreateTime(new Date());
            user.setPassword("eeeeeeeeeeee");
            userMapper.save(user);
        }

        return "success";
    }

    @RequestMapping("/user/get/{id}")
    public User get(@PathVariable Long id) {
        User user = userMapper.get(id);
        System.out.println(user.getId());
        return user;
    }

}

