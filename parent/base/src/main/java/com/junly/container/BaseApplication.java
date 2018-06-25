package com.junly.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BaseApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BaseApplication.class, args);
	}

}
