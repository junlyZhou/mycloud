package com.junly.base.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junly.base.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/test")
	public String testMethod() {
		System.out.println("hello world");
		
		Map<String, Object> queryStudentInfo = testService.queryStudentInfo("1");
		
		System.out.println(queryStudentInfo);
		System.out.println(queryStudentInfo);
		
		return "hello world";
	}
	
	
}
