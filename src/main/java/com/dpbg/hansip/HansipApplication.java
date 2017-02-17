package com.dpbg.hansip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class HansipApplication {

	public static void main(String[] args) {
		SpringApplication.run(HansipApplication.class, args);
	}
}
