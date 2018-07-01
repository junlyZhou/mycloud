package com.junly.base.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages="com.junly.base")
//@MapperScan(basePackages="com.junly.base.mapper")
public class BaseApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BaseApplication.class, args);
	}
}
