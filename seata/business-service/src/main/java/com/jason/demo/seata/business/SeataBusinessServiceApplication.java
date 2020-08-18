package com.jason.demo.seata.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.jason.demo.seata",
    exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
public class SeataBusinessServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataBusinessServiceApplication.class, args);
    }

}
