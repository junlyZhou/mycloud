package com.junly.authority.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAuthorityController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/zhang/{id}")
	public String authorName(@PathVariable("id") String id) {
		
		logger.debug("id:"+id);
		
		return "张三"+id;
	}
	
}
