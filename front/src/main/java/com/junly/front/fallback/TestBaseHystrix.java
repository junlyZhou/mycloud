package com.junly.front.fallback;

import org.springframework.stereotype.Component;

import com.junly.front.service.BaseFeignHystrixService;
/**
 * 断路器的feign支持的方式
 * 实现需要使用断路器的接口，推荐使用此方法
 * @author Administrator
 *
 */
@Component
public class TestBaseHystrix implements BaseFeignHystrixService {

	@Override
	public Object testMethod(String id) {
		//断路器的默认返回值
		return "testMethod";
	}



}
