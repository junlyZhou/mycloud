package com.junly.authority.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.junly.authority")
public class AuthorityApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AuthorityApplication.class, args);
	}

}
