package com.jason.demo.shardingsphere.service;

import com.jason.demo.shardingsphere.mapper.UserMapper;
import com.jason.demo.shardingsphere.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: jason
 * @Date: 2020-09-12
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Throwable.class)
    public int testRepeatedRead(Long userId) {
        log.info("test start...");
        User user = userMapper.selectByIdForUpadate(userId);
        Thread thread = Thread.currentThread();
        log.info("当前线程" + thread.getName());
        log.info("用户名字{},用户城市{}", user.getName(), user.getCityId());
        int res = userMapper.updateById(userId, "jason");
        log.info("res-------->{}", res);
        //int a = 6;
        //if (a > 1) {
        //    throw new RuntimeException("rollback");
        //}
        return res;
    }

}
