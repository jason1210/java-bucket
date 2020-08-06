package com.jason.demo.http.client;

import com.jason.demo.http.model.req.LoginUserReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: jason
 * @Date: 2020-08-06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestClientTest {
    @Autowired
    private TestClient testClient;

    @Test
    public void testGet() {
        System.out.println("result:" + testClient.get(437L));
    }

    @Test
    public void testPost() {
        LoginUserReq req = LoginUserReq.builder().username("xnxw_2020@").password("tunshuo_2020@").build();
        System.out.println("result:" + testClient.post(req));
    }

    @Test
    public void testGetPost() {
        testGet();
        testPost();
    }
}