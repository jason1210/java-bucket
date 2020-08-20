package com.jason.demo.clickfarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ClickFarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClickFarmApplication.class, args);
	}

}
