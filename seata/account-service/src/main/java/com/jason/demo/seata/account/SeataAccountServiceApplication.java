package com.jason.demo.seata.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.jason.demo.seata", exclude = DataSourceAutoConfiguration.class)
public class SeataAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountServiceApplication.class, args);
    }

}
