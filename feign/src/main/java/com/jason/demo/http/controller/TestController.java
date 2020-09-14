package com.jason.demo.http.controller;

import com.jason.demo.http.annotation.RetryProcess;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jason
 * @Date: 2020-09-14
 */
@RestController
@RequestMapping("/")
public class TestController {

    @RetryProcess(value = 3)
    @PostMapping("/testException")
    public void testException() throws Exception {
        // 这里为了方便测试手动抛一个异常，实际此处应该是调用接口逻辑
        throw new RuntimeException("测试重试异常");
    }

    @RetryProcess(value = 2)
    @PostMapping("/testException2")
    public void testException2() throws Exception {
        // 这里为了方便测试手动抛一个异常，实际此处应该是调用接口逻辑
        test();
    }

    private void test() throws Exception {
        // 这里为了方便测试手动抛一个异常，实际此处应该是调用接口逻辑
        throw new RuntimeException("测试重试异常2");
    }

}
