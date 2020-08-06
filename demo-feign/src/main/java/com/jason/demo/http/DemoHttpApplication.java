package com.jason.demo.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoHttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHttpApplication.class, args);
    }

}
