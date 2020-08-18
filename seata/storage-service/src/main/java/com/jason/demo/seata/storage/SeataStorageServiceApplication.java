package com.jason.demo.seata.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.jason.demo.seata", exclude = DataSourceAutoConfiguration.class)
public class SeataStorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServiceApplication.class, args);
    }

}
