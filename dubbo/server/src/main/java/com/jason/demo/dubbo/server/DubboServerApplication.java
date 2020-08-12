package com.jason.demo.dubbo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableDubbo  //会扫描所有的包，从中找出dubbo的@Service标注的类
// @DubboComponentScan(basePackages = "com.chy.user-service.service")  //只扫描指定的包
public class DubboServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboServerApplication.class, args);
    }

}
