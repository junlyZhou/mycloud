package com.junly.front.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

import com.jayway.jsonpath.Configuration;

@SpringBootApplication
@ComponentScan("com.junly.front")
@EnableEurekaClient
/**
 *当Application启动类路劲不能包括feign的包的时候就需要指定feign服务所在的包路劲
 */
@EnableFeignClients(basePackages = "com.junly.front.service")
@EnableAutoConfiguration
@EnableCircuitBreaker
@ComponentScan(basePackages="com.junly.front")
public class FrontApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(FrontApplication.class, args);
	}

}
