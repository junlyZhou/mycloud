package com.junly.base.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junly.base.service.TestService;
import com.junly.base.vo.User;

@RestController
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TestService testService;
	
	@Value("${spring.datasource.slaver.url}")
	private String url;
	
	@RequestMapping("/test")
	public Object testMethod(@RequestBody String id) {
		/*logger.info("日志工具测试：获取slaver的数据库url:"+url);
		logger.info("这个info级别的日志");
		logger.debug("这个上debug级别的日志");
		logger.warn("这个warn级别的日志");
		logger.error("这个error级别的日志");*/
		logger.info("id:"+id);
		Map<String, Object> queryStudentInfo = testService.queryStudentInfo(id);
		logger.info(queryStudentInfo == null? "":queryStudentInfo.toString());
		
		return queryStudentInfo;
	}
	
	@RequestMapping("/add/user")
	public String saveUser(@RequestBody User user) {
		logger.info("user:"+user);
		try {
			testService.saveUser(user);
		}catch(Exception e) {
			logger.info("异常了:"+e);
			return "exception";
		}
		logger.info("saveEnd:"+user);
		return "sucess";
	}
	
	
}
