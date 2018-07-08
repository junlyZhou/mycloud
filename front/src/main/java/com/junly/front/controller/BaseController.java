package com.junly.front.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junly.front.fallback.TestBaseHystrix;
import com.junly.front.service.BaseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.hystrix.FallbackHandler;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class BaseController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BaseService baseService;
	/**
	 * 采用restfull风格传递参数
	 * @GetMapping("/base/{id}")
	 * 当路径中的参数id("/base/{id}") 与方法中的参数String id 同名时，可以不用指定@PathVariable(value = "id")
	 * 		直接用@PathVariable注解参数即可
	 * @PathVariable(value = "id") String id
	 * @param id
	 * @return
	 */
	@GetMapping("/base/{id}")
	@HystrixCommand(fallbackMethod="testBaseHystrix")
	public Object testBaseController(@PathVariable(value = "id") String id) {
		logger.info("front controller id = "+id);
		Object testMethod = baseService.testMethod(id);
		return testMethod;
	}
	
	public Object testBaseHystrix(String id) {
		return "hystrix生效了";
	}
	
}
