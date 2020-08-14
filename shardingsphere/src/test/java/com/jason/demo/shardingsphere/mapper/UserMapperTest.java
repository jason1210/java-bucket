package com.jason.demo.shardingsphere.mapper;

import com.jason.demo.shardingsphere.ShardingsphereApplication;
import com.jason.demo.shardingsphere.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: jason
 * @Date: 2020-08-14
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingsphereApplication.class})
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        List<User> list = userMapper.getList();
        log.info("res" + list.size());
    }

}